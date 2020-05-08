package org.symehmoo.nucleus.controller;

import java.io.IOException;
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
import org.symehmoo.nucleus.model.TestExecutionDTO;
import org.symehmoo.nucleus.model.TestExecutionRunDTO;
import org.symehmoo.nucleus.service.TestConfigService;
import org.symehmoo.nucleus.service.TestExecutionService;

@RestController
@RequestMapping("/test")
public class TestConfigController {

	@Autowired
	private TestConfigService testConfigService;

	@Autowired
	private TestExecutionService testExecutionService;

	@GetMapping("/search")
	public Collection<TestConfigDTO> searchTest(Sort sort, TestConfigSearchDTO testConfigSearchDTO) {
		return testConfigService.searchTest(sort, testConfigSearchDTO);
	}

	@PostMapping("/create")
	public TestConfigDTO createTest(@RequestBody TestConfigCreationDTO testConfigCreationDTO) {
		return testConfigService.createTest(testConfigCreationDTO);
	}

	@PostMapping("/run")
	public TestExecutionDTO runTest(@RequestBody TestExecutionRunDTO testExecutionRunDTO) throws IOException {
		return testExecutionService.runTest(testExecutionRunDTO);
	}

}
