package org.symehmoo.nucleus.specification;

import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.symehmoo.nucleus.entity.TestConfig;
import org.symehmoo.nucleus.model.TestConfigSearchDTO;

@Component
public class TestConfigSpecifications extends BaseSpecification<TestConfig> {

	/**
	 * This method will create specification object for filtering data in test
	 * config table based on testConfigSearchDTO information
	 * 
	 * @param testConfigSearchDTO
	 * @return {@link Specification} object
	 */
	public Specification<TestConfig> createTestConfigSpecification(TestConfigSearchDTO testConfigSearchDTO) {
		Specification<TestConfig> testConfigSpecification = null;
		if (Objects.nonNull(testConfigSearchDTO.getTestName())) {
			testConfigSpecification = getEqualSpecification("testName", testConfigSearchDTO.getTestName());
		}
		if (Objects.nonNull(testConfigSearchDTO.getLobName())) {
			testConfigSpecification = this.getEqualSpecification("lobName", testConfigSearchDTO.getLobName())
					.and(testConfigSpecification);
		}
		if (Objects.nonNull(testConfigSearchDTO.getMnemonicsName())) {
			testConfigSpecification = this.getEqualSpecification("mnemonicName", testConfigSearchDTO.getMnemonicsName())
					.and(testConfigSpecification);
		}
		if (Objects.nonNull(testConfigSearchDTO.getAppComponentsName())) {
			testConfigSpecification = this
					.getEqualSpecification("appComponentName", testConfigSearchDTO.getAppComponentsName())
					.and(testConfigSpecification);
		}
		if (Objects.nonNull(testConfigSearchDTO.getTestType())) {
			testConfigSpecification = this.getEqualSpecification("testType", testConfigSearchDTO.getTestType())
					.and(testConfigSpecification);
		}
		if (Objects.nonNull(testConfigSearchDTO.getUserid_users())) {
			testConfigSpecification = this.getEqualSpecification("userid_users", testConfigSearchDTO.getUserid_users())
					.and(testConfigSpecification);
		}
		return testConfigSpecification;
	}
}
