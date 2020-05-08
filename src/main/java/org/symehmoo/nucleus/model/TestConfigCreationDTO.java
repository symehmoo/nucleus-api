package org.symehmoo.nucleus.model;

public class TestConfigCreationDTO {
	private String testName;
	private String gitRepoName;
	private String gitRepoURL;
	private String scriptName;
	private String env;
	private String userid_users;
	private String appComponentName;

	public TestConfigCreationDTO() {
		super();
	}

	public TestConfigCreationDTO(String gitRepoURL, String gitRepoName, String scriptName, String testName,
			String appComponentName, String env, String userid_users) {
		super();
		this.gitRepoURL = gitRepoURL;
		this.gitRepoName = gitRepoName;
		this.scriptName = scriptName;
		this.testName = testName;
		this.appComponentName = appComponentName;
		this.env = env;
		this.userid_users = userid_users;
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

	@Override
	public String toString() {
		return "TestConfigCreationDTO [testName=" + testName + ", gitRepoName=" + gitRepoName + ", gitRepoURL="
				+ gitRepoURL + ", scriptName=" + scriptName + ", env=" + env + ", userid_users=" + userid_users
				+ ", appComponentName=" + appComponentName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appComponentName == null) ? 0 : appComponentName.hashCode());
		result = prime * result + ((env == null) ? 0 : env.hashCode());
		result = prime * result + ((gitRepoName == null) ? 0 : gitRepoName.hashCode());
		result = prime * result + ((gitRepoURL == null) ? 0 : gitRepoURL.hashCode());
		result = prime * result + ((scriptName == null) ? 0 : scriptName.hashCode());
		result = prime * result + ((testName == null) ? 0 : testName.hashCode());
		result = prime * result + ((userid_users == null) ? 0 : userid_users.hashCode());
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
		return true;
	}

}
