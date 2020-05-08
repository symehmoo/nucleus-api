package org.symehmoo.nucleus.specification;

import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.symehmoo.nucleus.entity.TestExecution;
import org.symehmoo.nucleus.model.TestExecutionSearchDTO;

@Component
public class TestExecutionSpecifications extends BaseSpecification<TestExecution> {

	public Specification<TestExecution> createTestExecutionSpecification(
			TestExecutionSearchDTO testExecutionSearchDTO) {
		Specification<TestExecution> testExecutionSpecification = null;
		if (Objects.nonNull(testExecutionSearchDTO.getTestName())) {
			testExecutionSpecification = getEqualSpecification("testConfig.testName",
					testExecutionSearchDTO.getTestName());
		}
		return testExecutionSpecification;
	}
}
