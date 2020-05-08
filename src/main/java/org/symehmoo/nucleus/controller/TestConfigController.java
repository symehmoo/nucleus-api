package org.symehmoo.nucleus.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.symehmoo.nucleus.model.TestConfigCreationDTO;
import org.symehmoo.nucleus.model.TestConfigDTO;
import org.symehmoo.nucleus.model.TestConfigSearchDTO;
import org.symehmoo.nucleus.service.TestConfigService;

@RestController
@RequestMapping("/testConfig")
public class TestConfigController {

	@Autowired
	private TestConfigService testConfigService;

	@GetMapping("/search")
	public Collection<TestConfigDTO> searchTest(Sort sort, TestConfigSearchDTO testConfigSearchDTO) {
		return testConfigService.searchTest(sort, testConfigSearchDTO);
	}

	@PostMapping("create")
	public TestConfigDTO createTest(@RequestBody TestConfigCreationDTO testConfigCreationDTO) {
		return testConfigService.createTest(testConfigCreationDTO);
	}

}
