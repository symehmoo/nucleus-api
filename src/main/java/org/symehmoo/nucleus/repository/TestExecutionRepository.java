package org.symehmoo.nucleus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.symehmoo.nucleus.entity.TestExecution;

/**
 * Repository class to perform crud operation on Test execution table
 */
@Repository
public interface TestExecutionRepository
		extends JpaRepository<TestExecution, String>, JpaSpecificationExecutor<TestExecution> {

}
