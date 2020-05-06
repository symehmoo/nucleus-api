package org.symehmoo.nucleus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.symehmoo.nucleus.entity.TestExecution;

@Repository
public interface TestExecutionRepository extends JpaRepository<TestExecution, String> {

}
