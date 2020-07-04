package org.symehmoo.nucleus.model;

import java.math.BigDecimal;

/**
 * Data object used to create test config record
 */
public class TestConfigCreationDTO {
	private String testName;
	private String gitRepoName;
	private String gitRepoURL;
	private String scriptName;
	private String env;
	private String userid_users;
	private String mnemonicName;
	private String testType;
	private Integer numberOfAgents;
	private BigDecimal avg_tranpersec;
	private BigDecimal avg_responsetime;
	private BigDecimal err_perc;

	public TestConfigCreationDTO() {
		super();
	}

	public TestConfigCreationDTO(String gitRepoURL, String gitRepoName, String scriptName, String testName,
			String mnemonicName, String env, String userid_users, String testType, Integer numberOfAgents,
			BigDecimal avg_tranpersec, BigDecimal avg_responsetime, BigDecimal err_perc) {
		super();
		this.gitRepoURL = gitRepoURL;
		this.gitRepoName = gitRepoName;
		this.scriptName = scriptName;
		this.testName = testName;
		this.mnemonicName = mnemonicName;
		this.env = env;
		this.userid_users = userid_users;
		this.testType = testType;
		this.avg_tranpersec = avg_tranpersec;
		this.avg_responsetime = avg_responsetime;
		this.err_perc = err_perc;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getGitRepoName() {
		return gitRepoName;
	}

	public void setGitRepoName(String gitRepoName) {
		this.gitRepoName = gitRepoName;
	}

	public String getGitRepoURL() {
		return gitRepoURL;
	}

	public void setGitRepoURL(String gitRepoURL) {
		this.gitRepoURL = gitRepoURL;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getUserid_users() {
		return userid_users;
	}

	public void setUserid_users(String userid_users) {
		this.userid_users = userid_users;
	}

	public String getMnemonicName() {
		return mnemonicName;
	}

	public void setMnemonicName(String mnemonicName) {
		this.mnemonicName = mnemonicName;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public Integer getNumberOfAgents() {
		return numberOfAgents;
	}

	public void setNumberOfAgents(Integer numberOfAgents) {
		this.numberOfAgents = numberOfAgents;
	}

	public BigDecimal getAvg_tranpersec() {
		return avg_tranpersec;
	}

	public void setAvg_tranpersec(BigDecimal avg_tranpersec) {
		this.avg_tranpersec = avg_tranpersec;
	}

	public BigDecimal getAvg_responsetime() {
		return avg_responsetime;
	}

	public void setAvg_responsetime(BigDecimal avg_responsetime) {
		this.avg_responsetime = avg_responsetime;
	}

	public BigDecimal getErr_perc() {
		return err_perc;
	}

	public void setErr_perc(BigDecimal err_perc) {
		this.err_perc = err_perc;
	}

	@Override
	public String toString() {
		return "TestConfigCreationDTO [testName=" + testName + ", gitRepoName=" + gitRepoName + ", gitRepoURL="
				+ gitRepoURL + ", scriptName=" + scriptName + ", env=" + env + ", userid_users=" + userid_users
				+ ", mnemonicName=" + mnemonicName + ", testType=" + testType + ", numberOfAgents=" + numberOfAgents
				+ ", avg_responsetime=" + avg_responsetime + ", avg_tranpersec=" + avg_tranpersec + ", err_perc="
				+ err_perc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mnemonicName == null) ? 0 : mnemonicName.hashCode());
		result = prime * result + ((env == null) ? 0 : env.hashCode());
		result = prime * result + ((gitRepoName == null) ? 0 : gitRepoName.hashCode());
		result = prime * result + ((gitRepoURL == null) ? 0 : gitRepoURL.hashCode());
		result = prime * result + ((scriptName == null) ? 0 : scriptName.hashCode());
		result = prime * result + ((testName == null) ? 0 : testName.hashCode());
		result = prime * result + ((userid_users == null) ? 0 : userid_users.hashCode());
		result = prime * result + ((testType == null) ? 0 : testType.hashCode());
		result = prime * result + ((numberOfAgents == null) ? 0 : numberOfAgents.hashCode());
		result = prime * result + ((avg_responsetime == null) ? 0 : avg_responsetime.hashCode());
		result = prime * result + ((avg_tranpersec == null) ? 0 : avg_tranpersec.hashCode());
		result = prime * result + ((err_perc == null) ? 0 : err_perc.hashCode());
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
		TestConfigCreationDTO other = (TestConfigCreationDTO) obj;
		if (mnemonicName == null) {
			if (other.mnemonicName != null)
				return false;
		} else if (!mnemonicName.equals(other.mnemonicName))
			return false;
		if (env == null) {
			if (other.env != null)
				return false;
		} else if (!env.equals(other.env))
			return false;
		if (gitRepoName == null) {
			if (other.gitRepoName != null)
				return false;
		} else if (!gitRepoName.equals(other.gitRepoName))
			return false;
		if (gitRepoURL == null) {
			if (other.gitRepoURL != null)
				return false;
		} else if (!gitRepoURL.equals(other.gitRepoURL))
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
		if (userid_users == null) {
			if (other.userid_users != null)
				return false;
		} else if (!userid_users.equals(other.userid_users))
			return false;
		if (numberOfAgents == null) {
			if (other.numberOfAgents != null)
				return false;
		} else if (!numberOfAgents.equals(other.numberOfAgents))
			return false;
		if (testType == null) {
			if (other.testType != null)
				return false;
		} else if (!testType.equals(other.testType))
			return false;
		if (avg_responsetime == null) {
			if (other.avg_responsetime != null)
				return false;
		} else if (!avg_responsetime.equals(other.avg_responsetime))
			return false;
		if (avg_tranpersec == null) {
			if (other.avg_tranpersec != null)
				return false;
		} else if (!avg_tranpersec.equals(other.avg_tranpersec))
			return false;
		if (err_perc == null) {
			if (other.err_perc != null)
				return false;
		} else if (!err_perc.equals(other.err_perc))
			return false;
		return true;
	}

}
