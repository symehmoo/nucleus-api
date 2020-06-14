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

/**
 * Controller to expose test creation, search and run api
 */
@RestController
@RequestMapping("/test")
public class TestConfigController {

	@Autowired
	private TestConfigService testConfigService;

	@Autowired
	private TestExecutionService testExecutionService;

	/**
	 * API exposed to fetch test config records. Filtering can be applied on
	 * parameters defined on {@link TestConfigSearchDTO}
	 */
	@GetMapping("/search")
	public Collection<TestConfigDTO> searchTest(Sort sort, TestConfigSearchDTO testConfigSearchDTO) {
		return testConfigService.searchTest(sort, testConfigSearchDTO);
	}

	/**
	 * API exposed to create a new test config
	 */
	@PostMapping("/create")
	public TestConfigDTO createTest(@RequestBody TestConfigCreationDTO testConfigCreationDTO) {
		return testConfigService.createTest(testConfigCreationDTO);
	}

	/**
	 * API exposed to run a test execution
	 */
	@PostMapping("/run")
	public TestExecutionDTO runTest(@RequestBody TestExecutionRunDTO testExecutionRunDTO) throws IOException {
		return testExecutionService.runTest(testExecutionRunDTO);
	}

}
