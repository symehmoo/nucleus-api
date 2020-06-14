package org.symehmoo.nucleus.service;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.symehmoo.nucleus.model.TestConfigCreationDTO;
import org.symehmoo.nucleus.model.TestConfigDTO;
import org.symehmoo.nucleus.model.TestConfigSearchDTO;

public interface TestConfigService {

	/**
	 * Method to create new test record.
	 * 
	 * @param testConfigSearchDTO
	 * @return {@link TestConfigDTO} object
	 */
	public TestConfigDTO createTest(TestConfigCreationDTO testConfigCreationDTO);

	/**
	 * Method to fetch test config recods based on search fields present in
	 * testConfigSearchDTO. If values for all fields is null in
	 * testConfigSearchDTO then all records will be fetched. Can be sort using
	 * sort criteria
	 * 
	 * @param sort
	 * @param testConfigSearchDTO
	 * @return {@link TestConfigDTO} collection
	 */
	public Collection<TestConfigDTO> searchTest(Sort sort, TestConfigSearchDTO testConfigSearchDTO);

}
