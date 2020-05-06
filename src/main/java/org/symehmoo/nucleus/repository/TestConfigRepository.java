package org.symehmoo.nucleus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.symehmoo.nucleus.entity.TestConfig;

@Repository
public interface TestConfigRepository extends JpaRepository<TestConfig, String> {

}
