package org.symehmoo.nucleus.model;

/**
 * Data object used to update test execution status
 */
public class TestExecutionStatusUpdateDTO {
	private String runStatus;

	public TestExecutionStatusUpdateDTO() {
		super();
	}

	public TestExecutionStatusUpdateDTO(String runStatus) {
		super();
		this.runStatus = runStatus;
	}

	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	@Override
	public String toString() {
		return "TestExecutionStatusUpdateDTO [runStatus=" + runStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((runStatus == null) ? 0 : runStatus.hashCode());
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
		TestExecutionStatusUpdateDTO other = (TestExecutionStatusUpdateDTO) obj;
		if (runStatus == null) {
			if (other.runStatus != null)
				return false;
		} else if (!runStatus.equals(other.runStatus))
			return false;
		return true;
	}
}
