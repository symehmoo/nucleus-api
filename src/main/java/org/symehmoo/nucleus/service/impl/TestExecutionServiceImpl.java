package org.symehmoo.nucleus.service.impl;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.symehmoo.nucleus.constant.RunStatus;
import org.symehmoo.nucleus.entity.TestConfig;
import org.symehmoo.nucleus.entity.TestExecution;
import org.symehmoo.nucleus.model.TestExecutionDTO;
import org.symehmoo.nucleus.model.TestExecutionRunDTO;
import org.symehmoo.nucleus.model.TestExecutionSearchDTO;
import org.symehmoo.nucleus.repository.TestConfigRepository;
import org.symehmoo.nucleus.repository.TestExecutionRepository;
import org.symehmoo.nucleus.service.TestExecutionService;
import org.symehmoo.nucleus.specification.TestExecutionSpecifications;

@Service
public class TestExecutionServiceImpl implements TestExecutionService {

	private final TestExecutionRepository testExecutionRepository;

	private final TestConfigRepository testConfigRepository;

	private final TestExecutionSpecifications testExecutionSpecifications;

	@Value("${script.execution.cmd}")
	private String executionCmd;

	private static final Logger logger = LogManager.getLogger(TestExecutionServiceImpl.class);

	@Autowired
	public TestExecutionServiceImpl(TestExecutionRepository testExecutionRepository,
			TestConfigRepository testConfigRepository, TestExecutionSpecifications testExecutionSpecifications) {
		this.testExecutionRepository = testExecutionRepository;
		this.testConfigRepository = testConfigRepository;
		this.testExecutionSpecifications = testExecutionSpecifications;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TestExecutionDTO runTest(TestExecutionRunDTO testExecutionRunDTO) throws IOException {
		validateRequest(testExecutionRunDTO);
		TestConfig testConfig = testConfigRepository.findByTestNameIgnoreCase(testExecutionRunDTO.getTestName());
		if (Objects.isNull(testConfig)) {
			throw new RuntimeException("Test with this name not found");
		}
		// command generation step to run test
		String scriptCommand = MessageFormat.format(executionCmd, testConfig.getScriptName(), testConfig.getTestName(),
				testConfig.getGitRepoName(), testConfig.getGitRepoURL());
		ProcessBuilder pb = new ProcessBuilder(scriptCommand.split(" "));
		// executing command
		RunStatus runStatus = RunStatus.STARTED;
		try {
			pb.start();
		} catch (Exception ex) {
			logger.debug("Exception in starting test");
			logger.error(ex);
			runStatus = RunStatus.FAILED;
		}
		TestExecution testExecution = new TestExecution();
		testExecution.setStartTime(new Date());
		testExecution.setEndTime(new Date());
		testExecution.setRunStatus(runStatus.toString());
		testExecution.setTestConfig(testConfig);
		testExecution.setUserid_users(testExecutionRunDTO.getUserid_users());
		testExecution.setProcessId(RandomUtils.nextLong(1, 2000000));
		testExecutionRepository.save(testExecution);
		return convertToDTOFunc().apply(testExecution);
	}

	/**
	 * Method to validate parameters in post request object
	 * 
	 * @param testExecutionRunDTO
	 */
	private void validateRequest(TestExecutionRunDTO testExecutionRunDTO) {
		if (StringUtils.isBlank(testExecutionRunDTO.getTestName())) {
			throw new RuntimeException("Test name cannot be null");
		}
	}

	/**
	 * Function to convert Entity object To DTO object
	 * 
	 * @return {@link Function}
	 */
	private Function<TestExecution, TestExecutionDTO> convertToDTOFunc() {
		Function<TestExecution, TestExecutionDTO> convertToDTOFunc = testExecution -> {
			TestExecutionDTO testExecutionDTO = new TestExecutionDTO();
			testExecutionDTO.setId(testExecution.getId());
			testExecutionDTO.setProcessId(testExecution.getProcessId());
			testExecutionDTO.setRunStatus(testExecution.getRunStatus());
			testExecutionDTO.setTestName(testExecution.getTestConfig().getTestName());
			return testExecutionDTO;
		};
		return convertToDTOFunc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<TestExecutionDTO> searchTestExecution(Sort sort, TestExecutionSearchDTO testExecutionSearchDTO) {
		List<TestExecution> testExecutions = testExecutionRepository
				.findAll(testExecutionSpecifications.createTestExecutionSpecification(testExecutionSearchDTO), sort);
		List<TestExecutionDTO> testExecutionDTOs = testExecutions.stream().map(convertToDTOFunc())
				.collect(Collectors.toList());
		return testExecutionDTOs;
	}
}
