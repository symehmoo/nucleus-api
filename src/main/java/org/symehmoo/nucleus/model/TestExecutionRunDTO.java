package org.symehmoo.nucleus.model;

public class TestExecutionRunDTO {
	private String testName;
	private String userid_users;

	public TestExecutionRunDTO() {
		super();
	}

	public TestExecutionRunDTO(String testName, String userid_users) {
		super();
		this.testName = testName;
		this.userid_users = userid_users;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getUserid_users() {
		return userid_users;
	}

	public void setUserid_users(String userid_users) {
		this.userid_users = userid_users;
	}

	@Override
	public String toString() {
		return "TestExecutionRunDTO [testName=" + testName + ", userid_users=" + userid_users + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		TestExecutionRunDTO other = (TestExecutionRunDTO) obj;
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
