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

	@Autowired
	public TestExecutionServiceImpl(TestExecutionRepository testExecutionRepository,
			TestConfigRepository testConfigRepository, TestExecutionSpecifications testExecutionSpecifications) {
		this.testExecutionRepository = testExecutionRepository;
		this.testConfigRepository = testConfigRepository;
		this.testExecutionSpecifications = testExecutionSpecifications;
	}

	@Override
	public TestExecutionDTO runTest(TestExecutionRunDTO testExecutionRunDTO) throws IOException {
		validateRequest(testExecutionRunDTO);
		TestConfig testConfig = testConfigRepository.findByTestName(testExecutionRunDTO.getTestName());
		if (Objects.isNull(testConfig)) {
			throw new RuntimeException("Test with this name not found");
		}
		String scriptCommand = MessageFormat.format(executionCmd, testConfig.getScriptName(),
				testConfig.getScriptName(), testConfig.getGitRepoName(), testConfig.getGitRepoURL());
		ProcessBuilder pb = new ProcessBuilder(scriptCommand.split(" "));
		pb.start();
		TestExecution testExecution = new TestExecution();
		testExecution.setStartTime(new Date());
		testExecution.setEndTime(new Date());
		testExecution.setRunStatus(RunStatus.STARTED.toString());
		testExecution.setTestConfig(testConfig);
		testExecution.setUsers_idusers(testExecutionRunDTO.getUserid_users());
		testExecution.setProcessId(RandomUtils.nextLong(1, 2000000));
		testExecutionRepository.save(testExecution);
		return convertToDTOFunc().apply(testExecution);
	}

	private void validateRequest(TestExecutionRunDTO testExecutionRunDTO) {
		if (StringUtils.isBlank(testExecutionRunDTO.getTestName())) {
			throw new RuntimeException("Test name cannot be null");
		}
	}

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

	@Override
	public Collection<TestExecutionDTO> searchTestExecution(Sort sort, TestExecutionSearchDTO testExecutionSearchDTO) {
		List<TestExecution> testExecutions = testExecutionRepository
				.findAll(testExecutionSpecifications.createTestExecutionSpecification(testExecutionSearchDTO), sort);
		List<TestExecutionDTO> testExecutionDTOs = testExecutions.stream().map(convertToDTOFunc())
				.collect(Collectors.toList());
		return testExecutionDTOs;
	}
}
