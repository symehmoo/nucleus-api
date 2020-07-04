package org.symehmoo.nucleus.controller;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.symehmoo.nucleus.model.TestExecutionDTO;
import org.symehmoo.nucleus.model.TestExecutionSearchDTO;
import org.symehmoo.nucleus.model.TestExecutionStatusUpdateDTO;
import org.symehmoo.nucleus.service.TestExecutionService;

/**
 * Controller to expose test execution search api
 */
@RestController
public class TestExecutionController {

	@Autowired
	private TestExecutionService testExecutionService;

	@GetMapping("/testExecution")
	public Collection<TestExecutionDTO> getTestExecutionData(Sort sort, TestExecutionSearchDTO testExecutionSearchDTO) {
		return testExecutionService.searchTestExecution(sort, testExecutionSearchDTO);
	}

	/**
	 * API exposed to modify test execution record
	 */
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@PutMapping("/modifyTestExecution/{testExecutionId}")
	public void modifyTest(@PathVariable(name = "testExecutionId") UUID testExecutionId,
			@RequestBody TestExecutionStatusUpdateDTO testExecutionStatusUpdateDTO) {
		testExecutionService.updateTestExecutionStatus(testExecutionId, testExecutionStatusUpdateDTO);
	}

}
