package org.symehmoo.nucleus.specification;

import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.symehmoo.nucleus.entity.TestConfig;
import org.symehmoo.nucleus.model.TestConfigSearchDTO;

@Component
public class TestConfigSpecifications extends BaseSpecification<TestConfig> {

	public Specification<TestConfig> createTestConfigSpecification(TestConfigSearchDTO testConfigSearchDTO) {
		Specification<TestConfig> testConfigSpecification = null;
		if (Objects.nonNull(testConfigSearchDTO.getTestName())) {
			testConfigSpecification = getEqualSpecification("testName", testConfigSearchDTO.getTestName());
		}
		if (Objects.nonNull(testConfigSearchDTO.getLobName())) {
			testConfigSpecification = this.getEqualSpecification("lob.lobName", testConfigSearchDTO.getLobName())
					.and(testConfigSpecification);
		}
		if (Objects.nonNull(testConfigSearchDTO.getMnemonicsName())) {
			testConfigSpecification = this
					.getEqualSpecification("mnemonic.mnemonicsName", testConfigSearchDTO.getMnemonicsName())
					.and(testConfigSpecification);
		}
		if (Objects.nonNull(testConfigSearchDTO.getAppComponentsName())) {
			testConfigSpecification = this.getEqualSpecification("appComponents.appComponentsName",
					testConfigSearchDTO.getAppComponentsName()).and(testConfigSpecification);
		}
		return testConfigSpecification;
	}
}
