package org.symehmoo.nucleus.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.symehmoo.nucleus.entity.AppComponents;
import org.symehmoo.nucleus.entity.Mnemonic;
import org.symehmoo.nucleus.entity.TestConfig;
import org.symehmoo.nucleus.model.TestConfigCreationDTO;
import org.symehmoo.nucleus.model.TestConfigDTO;
import org.symehmoo.nucleus.model.TestConfigSearchDTO;
import org.symehmoo.nucleus.model.TestConfigUpdateDTO;
import org.symehmoo.nucleus.repository.AppComponentsRepository;
import org.symehmoo.nucleus.repository.MnemonicRepository;
import org.symehmoo.nucleus.repository.TestConfigRepository;
import org.symehmoo.nucleus.service.TestConfigService;
import org.symehmoo.nucleus.specification.TestConfigSpecifications;

@Service
public class TestConfigServiceImpl implements TestConfigService {

	private final TestConfigRepository testConfigRepository;

	private final AppComponentsRepository appComponentsRepository;

	private final TestConfigSpecifications testConfigSpecifications;

	private final MnemonicRepository mnemonicRepository;

	@Autowired
	public TestConfigServiceImpl(TestConfigRepository testConfigRepository,
			TestConfigSpecifications testConfigSpecifications, AppComponentsRepository appComponentsRepository,
			MnemonicRepository mnemonicRepository) {
		this.testConfigRepository = testConfigRepository;
		this.testConfigSpecifications = testConfigSpecifications;
		this.appComponentsRepository = appComponentsRepository;
		this.mnemonicRepository = mnemonicRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TestConfigDTO createTest(TestConfigCreationDTO testConfigCreationDTO) {
		validateRequest(testConfigCreationDTO);
		TestConfig testConfig = testConfigRepository.findByTestNameIgnoreCase(testConfigCreationDTO.getTestName());
		if (Objects.nonNull(testConfig)) {
			throw new RuntimeException("Test with this name already exists");
		}
		Mnemonic mnemonic = mnemonicRepository.findByMnemonicsNameIgnoreCase(testConfigCreationDTO.getMnemonicName());
		if (Objects.isNull(mnemonic)) {
			throw new RuntimeException("Mnemonic with this name not found");
		}
		AppComponents appComponents = appComponentsRepository.findByMnemonic_IdAndAppComponentsNameIgnoreCase(
				mnemonic.getId(), testConfigCreationDTO.getGitRepoName());
		if (Objects.isNull(appComponents)) {
			appComponents = new AppComponents();
			appComponents.setMnemonic(mnemonic);
			appComponents.setAppComponentsName(testConfigCreationDTO.getGitRepoName());
			appComponentsRepository.save(appComponents);
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
		newTestConfig.setUserid_users(testConfigCreationDTO.getUserid_users());
		newTestConfig.setTestType(testConfigCreationDTO.getTestType());
		newTestConfig.setNumberOfAgents(testConfigCreationDTO.getNumberOfAgents());
		testConfigRepository.save(newTestConfig);
		return convertToDTOFunc().apply(newTestConfig);
	}

	/**
	 * Method to validate parameters in post request object
	 * 
	 * @param testConfigCreationDTO
	 */
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

		if (StringUtils.isBlank(testConfigCreationDTO.getMnemonicName())) {
			throw new RuntimeException("Mnemonic name cannot be null");
		}

		if (StringUtils.isBlank(testConfigCreationDTO.getGitRepoURL())) {
			throw new RuntimeException("Git repo url cannot be null");
		}
	}

	/**
	 * Function to convert Entity object To DTO object
	 * 
	 * @return {@link Function}
	 */
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
			testConfigDTO.setUserid_users(testConfig.getUserid_users());
			testConfigDTO.setTestType(testConfig.getTestType());
			testConfigDTO.setNumberOfAgents(testConfig.getNumberOfAgents());
			return testConfigDTO;
		};
		return convertToDTOFunc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<TestConfigDTO> searchTest(Sort sort, TestConfigSearchDTO testConfigSearchDTO) {
		List<TestConfig> testConfigDatas = testConfigRepository
				.findAll(testConfigSpecifications.createTestConfigSpecification(testConfigSearchDTO), sort);
		List<TestConfigDTO> testConfigDtos = testConfigDatas.stream().map(convertToDTOFunc())
				.collect(Collectors.toList());
		return testConfigDtos;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateTest(UUID testConfigId, TestConfigUpdateDTO testConfigUpdateDTO) {
		validatePutRequest(testConfigId, testConfigUpdateDTO);
		TestConfig testConfig = testConfigRepository.findByTestNameIgnoreCase(testConfigUpdateDTO.getTestName());
		if (Objects.nonNull(testConfig) && !testConfig.getId().equals(testConfigId)) {
			throw new RuntimeException("Test name already in use. Please try other name");
		}
		TestConfig test = testConfigRepository.findById(testConfigId).orElse(null);
		if (Objects.isNull(test)) {
			throw new RuntimeException("Test with this id not found");
		}
		test.setTestName(testConfigUpdateDTO.getTestName());
		test.setScriptName(testConfigUpdateDTO.getScriptName());
		test.setNumberOfAgents(testConfigUpdateDTO.getNumberOfAgents());
		testConfigRepository.save(test);
	}

	/**
	 * Method to validate parameters in update request object
	 * 
	 * @param testConfigUpdateDTO
	 */
	private void validatePutRequest(UUID testConfigId, TestConfigUpdateDTO testConfigUpdateDTO) {
		if (Objects.isNull(testConfigId)) {
			throw new RuntimeException("Test config id cannot be null");
		}
		if (StringUtils.isBlank(testConfigUpdateDTO.getTestName())) {
			throw new RuntimeException("Test name cannot be null");
		}

		if (StringUtils.isBlank(testConfigUpdateDTO.getScriptName())) {
			throw new RuntimeException("Script name cannot be null");
		}
	}
}
