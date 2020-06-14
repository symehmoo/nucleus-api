package org.symehmoo.nucleus.specification;

import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.symehmoo.nucleus.entity.TestExecution;
import org.symehmoo.nucleus.model.TestExecutionSearchDTO;

@Component
public class TestExecutionSpecifications extends BaseSpecification<TestExecution> {

	/**
	 * This method will create specification object for filtering data in test
	 * execution table based on testExecutionSearchDTO information
	 * 
	 * @param testExecutionSearchDTO
	 * @return {@link Specification} object
	 */
	public Specification<TestExecution> createTestExecutionSpecification(
			TestExecutionSearchDTO testExecutionSearchDTO) {
		Specification<TestExecution> testExecutionSpecification = null;
		if (Objects.nonNull(testExecutionSearchDTO.getTestName())) {
			testExecutionSpecification = getEqualSpecification("testConfig.testName",
					testExecutionSearchDTO.getTestName());
		}
		if (Objects.nonNull(testExecutionSearchDTO.getRunStatus())) {
			testExecutionSpecification = getEqualSpecification("runStatus", testExecutionSearchDTO.getRunStatus());
		}
		if (Objects.nonNull(testExecutionSearchDTO.getExecutionId())) {
			testExecutionSpecification = getEqualSpecification("id", testExecutionSearchDTO.getExecutionId());
		}
		return testExecutionSpecification;
	}
}
