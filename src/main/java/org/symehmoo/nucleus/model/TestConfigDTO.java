package org.symehmoo.nucleus.model;

import java.util.UUID;

/**
 * Data object to return test config details
 */
public class TestConfigDTO {
	private UUID id;
	private String testName;
	private String gitRepoName;
	private String gitRepoURL;
	private String scriptName;
	private String env;
	private String userid_users;
	private String appComponentName;
	private String mnemonicsName;
	private String lobName;
	private String testType;
	private Integer numberOfAgents;

	public TestConfigDTO() {
		super();
	}

	public TestConfigDTO(UUID id, String testName, String gitRepoName, String gitRepoURL, String scriptName, String env,
			String userid_users, String appComponentName, String mnemonicsName, String lobName, String testType,
			Integer numberOfAgents) {
		super();
		this.id = id;
		this.testName = testName;
		this.gitRepoName = gitRepoName;
		this.gitRepoURL = gitRepoURL;
		this.scriptName = scriptName;
		this.env = env;
		this.userid_users = userid_users;
		this.appComponentName = appComponentName;
		this.mnemonicsName = mnemonicsName;
		this.lobName = lobName;
		this.testType = testType;
		this.numberOfAgents = numberOfAgents;
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

	public String getAppComponentName() {
		return appComponentName;
	}

	public void setAppComponentName(String appComponentName) {
		this.appComponentName = appComponentName;
	}

	public String getMnemonicsName() {
		return mnemonicsName;
	}

	public void setMnemonicsName(String mnemonicsName) {
		this.mnemonicsName = mnemonicsName;
	}

	public String getLobName() {
		return lobName;
	}

	public void setLobName(String lobName) {
		this.lobName = lobName;
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

	@Override
	public String toString() {
		return "TestConfigDTO [id=" + id + ", testName=" + testName + ", gitRepoName=" + gitRepoName + ", gitRepoURL="
				+ gitRepoURL + ", scriptName=" + scriptName + ", env=" + env + ", userid_users=" + userid_users
				+ ", appComponentName=" + appComponentName + ", mnemonicsName=" + mnemonicsName + ", lobName=" + lobName
				+ ", testType=" + testType + ", numberOfAgents=" + numberOfAgents + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appComponentName == null) ? 0 : appComponentName.hashCode());
		result = prime * result + ((env == null) ? 0 : env.hashCode());
		result = prime * result + ((gitRepoName == null) ? 0 : gitRepoName.hashCode());
		result = prime * result + ((gitRepoURL == null) ? 0 : gitRepoURL.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lobName == null) ? 0 : lobName.hashCode());
		result = prime * result + ((mnemonicsName == null) ? 0 : mnemonicsName.hashCode());
		result = prime * result + ((scriptName == null) ? 0 : scriptName.hashCode());
		result = prime * result + ((testName == null) ? 0 : testName.hashCode());
		result = prime * result + ((userid_users == null) ? 0 : userid_users.hashCode());
		result = prime * result + ((testType == null) ? 0 : testType.hashCode());
		result = prime * result + ((numberOfAgents == null) ? 0 : numberOfAgents.hashCode());
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
		TestConfigDTO other = (TestConfigDTO) obj;
		if (appComponentName == null) {
			if (other.appComponentName != null)
				return false;
		} else if (!appComponentName.equals(other.appComponentName))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (testType == null) {
			if (other.testType != null)
				return false;
		} else if (!testType.equals(other.testType))
			return false;
		if (numberOfAgents == null) {
			if (other.numberOfAgents != null)
				return false;
		} else if (!numberOfAgents.equals(other.numberOfAgents))
			return false;
		return true;
	}
}
