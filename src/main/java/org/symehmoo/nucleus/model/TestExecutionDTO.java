package org.symehmoo.nucleus.model;

import java.util.UUID;

public class TestExecutionDTO {
	private UUID id;
	private String testName;
	private String runStatus;
	private Long processId;

	public TestExecutionDTO() {
		super();
	}

	public TestExecutionDTO(UUID id, String testName, String runStatus, Long processId) {
		super();
		this.id = id;
		this.testName = testName;
		this.runStatus = runStatus;
		this.processId = processId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

	@Override
	public String toString() {
		return "TestExecutionDTO [id=" + id + ", testName=" + testName + ", runStatus=" + runStatus + ", processId="
				+ processId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((processId == null) ? 0 : processId.hashCode());
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
		TestExecutionDTO other = (TestExecutionDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (processId != other.processId)
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
