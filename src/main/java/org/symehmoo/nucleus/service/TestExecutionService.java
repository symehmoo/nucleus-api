package org.symehmoo.nucleus.service;

import java.io.IOException;
import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.symehmoo.nucleus.model.TestExecutionDTO;
import org.symehmoo.nucleus.model.TestExecutionRunDTO;
import org.symehmoo.nucleus.model.TestExecutionSearchDTO;

public interface TestExecutionService {

	public TestExecutionDTO runTest(TestExecutionRunDTO testExecutionRunDTO) throws IOException;

	public Collection<TestExecutionDTO> searchTestExecution(Sort sort, TestExecutionSearchDTO testExecutionSearchDTO);

}
