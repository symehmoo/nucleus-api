package org.symehmoo.nucleus.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.symehmoo.nucleus.model.TestExecutionDTO;
import org.symehmoo.nucleus.model.TestExecutionSearchDTO;
import org.symehmoo.nucleus.service.TestExecutionService;

@RestController
public class TestExecutionController {

	@Autowired
	private TestExecutionService testExecutionService;

	@GetMapping("/testExecution")
	public Collection<TestExecutionDTO> getTestExecutionData(Sort sort, TestExecutionSearchDTO testExecutionSearchDTO) {
		return testExecutionService.searchTestExecution(sort, testExecutionSearchDTO);
	}

}
