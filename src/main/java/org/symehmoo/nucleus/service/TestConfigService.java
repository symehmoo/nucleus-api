package org.symehmoo.nucleus.service;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.symehmoo.nucleus.model.TestConfigCreationDTO;
import org.symehmoo.nucleus.model.TestConfigDTO;
import org.symehmoo.nucleus.model.TestConfigSearchDTO;

public interface TestConfigService {

	public TestConfigDTO createTest(TestConfigCreationDTO testConfigCreationDTO);

	public Collection<TestConfigDTO> searchTest(Sort sort, TestConfigSearchDTO testConfigSearchDTO);

}
