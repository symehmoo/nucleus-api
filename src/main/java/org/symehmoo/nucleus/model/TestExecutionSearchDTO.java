package org.symehmoo.nucleus.model;

/**
 * Data object used to search test execution
 */
public class TestExecutionSearchDTO {
	private String testName;

	public TestExecutionSearchDTO() {
		super();
	}

	public TestExecutionSearchDTO(String testName) {
		super();
		this.testName = testName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "TestExecutionSearchDTO [testName=" + testName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (testName == null) {
			if (other.testName != null)
				return false;
		} else if (!testName.equals(other.testName))
			return false;
		return true;
	}
}
