package org.symehmoo.nucleus.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.symehmoo.nucleus.model.TestConfigCreationDTO;
import org.symehmoo.nucleus.model.TestConfigDTO;
import org.symehmoo.nucleus.model.TestConfigSearchDTO;
import org.symehmoo.nucleus.model.TestConfigUpdateDTO;
import org.symehmoo.nucleus.model.TestExecutionDTO;
import org.symehmoo.nucleus.model.TestExecutionRunDTO;
import org.symehmoo.nucleus.service.TestConfigService;
import org.symehmoo.nucleus.service.TestExecutionService;

/**
 * Controller to expose test creation,update test, search and run api
 */
@RestController
public class TestConfigController {

	@Autowired
	private TestConfigService testConfigService;

	@Autowired
	private TestExecutionService testExecutionService;

	/**
	 * API exposed to fetch test config records. Filtering can be applied on
	 * parameters defined on {@link TestConfigSearchDTO}
	 */
	@GetMapping("/searchTest")
	public Collection<TestConfigDTO> searchTest(Sort sort, TestConfigSearchDTO testConfigSearchDTO) {
		return testConfigService.searchTest(sort, testConfigSearchDTO);
	}

	/**
	 * API exposed to create a new test config
	 */
	@PostMapping("/createTest")
	public TestConfigDTO createTest(@RequestBody TestConfigCreationDTO testConfigCreationDTO) {
		return testConfigService.createTest(testConfigCreationDTO);
	}

	/**
	 * API exposed to run a test execution
	 */
	@PostMapping("/runTest")
	public TestExecutionDTO runTest(@RequestBody TestExecutionRunDTO testExecutionRunDTO) throws IOException {
		return testExecutionService.runTest(testExecutionRunDTO);
	}

	/**
	 * API exposed to update test config record
	 */
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@PutMapping("/modifyTest/{testConfigId}")
	public void modifyTest(@PathVariable(name = "testConfigId") UUID testConfigId,
			@RequestBody TestConfigUpdateDTO testConfigUpdateDTO) {
		testConfigService.updateTest(testConfigId, testConfigUpdateDTO);
	}

}
