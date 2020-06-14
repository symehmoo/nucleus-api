package org.symehmoo.nucleus.model;

import java.util.UUID;

/**
 * Data object used to search test execution
 */
public class TestExecutionSearchDTO {
	private String testName;
	private UUID executionId;
	private String runStatus;

	public TestExecutionSearchDTO() {
		super();
	}

	public TestExecutionSearchDTO(String testName, UUID executionId, String runStatus) {
		super();
		this.testName = testName;
		this.executionId = executionId;
		this.runStatus = runStatus;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public UUID getExecutionId() {
		return executionId;
	}

	public void setExecutionId(UUID executionId) {
		this.executionId = executionId;
	}

	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	@Override
	public String toString() {
		return "TestExecutionSearchDTO [testName=" + testName + ", executionId=" + executionId + ", runStatus="
				+ runStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((executionId == null) ? 0 : executionId.hashCode());
		result = prime * result + ((runStatus == null) ? 0 : runStatus.hashCode());
		result = prime * result + ((testName == null) ? 0 : testName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestExecutionSearchDTO other = (TestExecutionSearchDTO) obj;
		if (executionId == null) {
			if (other.executionId != null)
				return false;
		} else if (!executionId.equals(other.executionId))
			return false;
		if (runStatus == null) {
			if (other.runStatus != null)
				return false;
		} else if (!runStatus.equals(other.runStatus))
			return false;
		if (testName == null) {
			if (other.testName != null)
				return false;
		} else if (!testName.equals(other.testName))
			return false;
		return true;
	}
}
