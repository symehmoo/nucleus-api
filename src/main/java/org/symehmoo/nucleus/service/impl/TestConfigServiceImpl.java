package org.symehmoo.nucleus.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.symehmoo.nucleus.entity.AppComponents;
import org.symehmoo.nucleus.entity.TestConfig;
import org.symehmoo.nucleus.model.TestConfigCreationDTO;
import org.symehmoo.nucleus.model.TestConfigDTO;
import org.symehmoo.nucleus.model.TestConfigSearchDTO;
import org.symehmoo.nucleus.repository.AppComponentsRepository;
import org.symehmoo.nucleus.repository.TestConfigRepository;
import org.symehmoo.nucleus.service.TestConfigService;
import org.symehmoo.nucleus.specification.TestConfigSpecifications;

@Service
public class TestConfigServiceImpl implements TestConfigService {

	private final TestConfigRepository testConfigRepository;

	private final AppComponentsRepository appComponentsRepository;

	private final TestConfigSpecifications testConfigSpecifications;

	@Autowired
	public TestConfigServiceImpl(TestConfigRepository testConfigRepository,
			TestConfigSpecifications testConfigSpecifications, AppComponentsRepository appComponentsRepository) {
		this.testConfigRepository = testConfigRepository;
		this.testConfigSpecifications = testConfigSpecifications;
		this.appComponentsRepository = appComponentsRepository;
	}

	@Override
	public TestConfigDTO createTest(TestConfigCreationDTO testConfigCreationDTO) {
		validateRequest(testConfigCreationDTO);
		TestConfig testConfig = testConfigRepository.findByTestName(testConfigCreationDTO.getTestName());
		if (Objects.nonNull(testConfig)) {
			throw new RuntimeException("Test with this name already exists");
		}
		AppComponents appComponents = appComponentsRepository
				.findByAppComponentsName(testConfigCreationDTO.getAppComponentName());
		if (Objects.isNull(appComponents)) {
			throw new RuntimeException("App component not found with this name");
		}
		TestConfig newTestConfig = new TestConfig();
		newTestConfig.setAppComponents(appComponents);
		newTestConfig.setEnv(testConfigCreationDTO.getEnv());
		newTestConfig.setGitRepoName(testConfigCreationDTO.getGitRepoName());
		newTestConfig.setGitRepoURL(testConfigCreationDTO.getGitRepoURL());
		if (Objects.nonNull(appComponents)) {
			newTestConfig.setMnemonic(appComponents.getMnemonic());
			newTestConfig.setLob(appComponents.getMnemonic().getLob());
		}
		newTestConfig.setScriptName(testConfigCreationDTO.getScriptName());
		newTestConfig.setTestName(testConfigCreationDTO.getTestName());
		newTestConfig.setUsers_idusers(testConfigCreationDTO.getUserid_users());
		testConfigRepository.save(newTestConfig);
		return convertToDTOFunc().apply(newTestConfig);
	}

	private void validateRequest(TestConfigCreationDTO testConfigCreationDTO) {
		if (StringUtils.isBlank(testConfigCreationDTO.getTestName())) {
			throw new RuntimeException("Test name cannot be null");
		}
		if (StringUtils.isBlank(testConfigCreationDTO.getScriptName())) {
			throw new RuntimeException("Script name cannot be null");
		}
		if (StringUtils.isBlank(testConfigCreationDTO.getGitRepoName())) {
			throw new RuntimeException("Git repo name cannot be null");
		}

		if (StringUtils.isBlank(testConfigCreationDTO.getAppComponentName())) {
			throw new RuntimeException("App components name cannot be null");
		}
		if (StringUtils.isBlank(testConfigCreationDTO.getGitRepoURL())) {
			throw new RuntimeException("Git repo url cannot be null");
		}

	}

	private Function<TestConfig, TestConfigDTO> convertToDTOFunc() {
		Function<TestConfig, TestConfigDTO> convertToDTOFunc = testConfig -> {
			TestConfigDTO testConfigDTO = new TestConfigDTO();
			testConfigDTO.setAppComponentName(testConfig.getAppComponents().getAppComponentsName());
			testConfigDTO.setEnv(testConfig.getEnv());
			testConfigDTO.setGitRepoName(testConfig.getGitRepoName());
			testConfigDTO.setGitRepoURL(testConfig.getGitRepoURL());
			testConfigDTO.setId(testConfig.getId());
			testConfigDTO.setLobName(testConfig.getLob().getLobName());
			testConfigDTO.setMnemonicsName(testConfig.getMnemonic().getMnemonicsName());
			testConfigDTO.setScriptName(testConfig.getScriptName());
			testConfigDTO.setTestName(testConfig.getTestName());
			testConfigDTO.setUserid_users(testConfig.getUsers_idusers());
			return testConfigDTO;
		};
		return convertToDTOFunc;
	}

	@Override
	public Collection<TestConfigDTO> searchTest(Sort sort, TestConfigSearchDTO testConfigSearchDTO) {
		List<TestConfig> testConfigDatas = testConfigRepository
				.findAll(testConfigSpecifications.createTestConfigSpecification(testConfigSearchDTO), sort);
		List<TestConfigDTO> testConfigDtos = testConfigDatas.stream().map(convertToDTOFunc())
				.collect(Collectors.toList());
		return testConfigDtos;
	}
}
