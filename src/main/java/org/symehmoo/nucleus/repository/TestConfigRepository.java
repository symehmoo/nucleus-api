package org.symehmoo.nucleus.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.symehmoo.nucleus.entity.TestConfig;

/**
 * Repository class to perform crud operation on Test config table
 */
@Repository
public interface TestConfigRepository extends JpaRepository<TestConfig, UUID>, JpaSpecificationExecutor<TestConfig> {

	/**
	 * Method to find test config record by test name
	 * 
	 * @param testName
	 * @return {@link TestConfig}
	 */
	public TestConfig findByTestNameIgnoreCase(String testName);

}
