package org.symehmoo.nucleus.model;

public class TestConfigSearchDTO {
	private String lobName;
	private String mnemonicsName;
	private String appComponentsName;
	private String testName;

	public TestConfigSearchDTO() {
		super();
	}

	public TestConfigSearchDTO(String lobName, String mnemonicsName, String appComponentsName, String testName) {
		super();
		this.lobName = lobName;
		this.mnemonicsName = mnemonicsName;
		this.appComponentsName = appComponentsName;
		this.testName = testName;
	}

	public String getLobName() {
		return lobName;
	}

	public void setLobName(String lobName) {
		this.lobName = lobName;
	}

	public String getMnemonicsName() {
		return mnemonicsName;
	}

	public void setMnemonicsName(String mnemonicsName) {
		this.mnemonicsName = mnemonicsName;
	}

	public String getAppComponentsName() {
		return appComponentsName;
	}

	public void setAppComponentsName(String appComponentsName) {
		this.appComponentsName = appComponentsName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "TestConfigSearchDTO [lobName=" + lobName + ", mnemonicsName=" + mnemonicsName + ", appComponentsName="
				+ appComponentsName + ", testName=" + testName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appComponentsName == null) ? 0 : appComponentsName.hashCode());
		result = prime * result + ((lobName == null) ? 0 : lobName.hashCode());
		result = prime * result + ((mnemonicsName == null) ? 0 : mnemonicsName.hashCode());
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
		TestConfigSearchDTO other = (TestConfigSearchDTO) obj;
		if (appComponentsName == null) {
			if (other.appComponentsName != null)
				return false;
		} else if (!appComponentsName.equals(other.appComponentsName))
			return false;
		if (lobName == null) {
			if (other.lobName != null)
				return false;
		} else if (!lobName.equals(other.lobName))
			return false;
		if (mnemonicsName == null) {
			if (other.mnemonicsName != null)
				return false;
		} else if (!mnemonicsName.equals(other.mnemonicsName))
			return false;
		if (testName == null) {
			if (other.testName != null)
				return false;
		} else if (!testName.equals(other.testName))
			return false;
		return true;
	}
}
