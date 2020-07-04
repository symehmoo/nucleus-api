package org.symehmoo.nucleus.service;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.symehmoo.nucleus.model.TestExecutionDTO;
import org.symehmoo.nucleus.model.TestExecutionRunDTO;
import org.symehmoo.nucleus.model.TestExecutionSearchDTO;
import org.symehmoo.nucleus.model.TestExecutionStatusUpdateDTO;

public interface TestExecutionService {

	/**
	 * Method to run test.
	 * 
	 * @param testConfigSearchDTO
	 * @return {@link TestExecutionDTO} object
	 */
	public TestExecutionDTO runTest(TestExecutionRunDTO testExecutionRunDTO) throws IOException;

	/**
	 * Method to fetch test execution recods based on search fields present in
	 * testExecutionSearchDTO. If values for all fields is null in
	 * testExecutionSearchDTO then all records will be fetched. Can be sort
	 * using sort criteria
	 * 
	 * @param sort
	 * @param testExecutionSearchDTO
	 * @return {@link TestExecutionDTO} collection
	 */
	public Collection<TestExecutionDTO> searchTestExecution(Sort sort, TestExecutionSearchDTO testExecutionSearchDTO);

	/**
	 * Method to update test execution status.
	 * 
	 * @param testExecutionStatusUpdateDTO
	 */
	public void updateTestExecutionStatus(UUID testExecutionId,
			TestExecutionStatusUpdateDTO testExecutionStatusUpdateDTO);

}
