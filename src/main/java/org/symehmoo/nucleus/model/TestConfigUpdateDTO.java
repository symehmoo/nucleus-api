package org.symehmoo.nucleus.model;

/**
 * Data object used to update test config record
 */
public class TestConfigUpdateDTO {
	private String testName;
	private String scriptName;
	private Integer numberOfAgents;

	public TestConfigUpdateDTO() {
		super();
	}

	public TestConfigUpdateDTO(String testName, String scriptName, Integer numberOfAgents) {
		super();
		this.testName = testName;
		this.scriptName = scriptName;
		this.numberOfAgents = numberOfAgents;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public Integer getNumberOfAgents() {
		return numberOfAgents;
	}

	public void setNumberOfAgents(Integer numberOfAgents) {
		this.numberOfAgents = numberOfAgents;
	}

	@Override
	public String toString() {
		return "TestConfigUpdateDTO [testName=" + testName + ", scriptName=" + scriptName + ", numberOfAgents="
				+ numberOfAgents + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberOfAgents == null) ? 0 : numberOfAgents.hashCode());
		result = prime * result + ((scriptName == null) ? 0 : scriptName.hashCode());
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
		TestConfigUpdateDTO other = (TestConfigUpdateDTO) obj;
		if (numberOfAgents == null) {
			if (other.numberOfAgents != null)
				return false;
		} else if (!numberOfAgents.equals(other.numberOfAgents))
			return false;
		if (scriptName == null) {
			if (other.scriptName != null)
				return false;
		} else if (!scriptName.equals(other.scriptName))
			return false;
		if (testName == null) {
			if (other.testName != null)
				return false;
		} else if (!testName.equals(other.testName))
			return false;
		return true;
	}

}
