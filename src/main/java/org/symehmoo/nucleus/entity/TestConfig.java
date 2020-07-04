package org.symehmoo.nucleus.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Table mapping to store test config data
 */
@Entity
@Table(name = "testconfig")
public class TestConfig extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "testname")
	private String testName;

	@Column(name = "gitreponame")
	private String gitRepoName;

	@Column(name = "gitrepourl")
	private String gitRepoURL;

	@Column(name = "scriptname")
	private String scriptName;

	@Column(name = "env")
	private String env;

	@Column(name = "numberofagents")
	private Integer numberOfAgents;

	@Column(name = "testtype")
	private String testType;

	@Column(name = "userid_users")
	private String userid_users;

	@Column(name = "lobname")
	private String lobName;

	@Column(name = "mnemonicname")
	private String mnemonicName;

	@Column(name = "appcomponentname")
	private String appComponentName;

	@Column(name = "avg_tranpersec")
	private BigDecimal avg_tranpersec;

	@Column(name = "avg_responsetime")
	private BigDecimal avg_responsetime;

	@Column(name = "err_perc")
	private BigDecimal err_perc;

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

	public String getLobName() {
		return lobName;
	}

	public void setLobName(String lobName) {
		this.lobName = lobName;
	}

	public String getMnemonicName() {
		return mnemonicName;
	}

	public void setMnemonicName(String mnemonicName) {
		this.mnemonicName = mnemonicName;
	}

	public String getAppComponentName() {
		return appComponentName;
	}

	public void setAppComponentName(String appComponentName) {
		this.appComponentName = appComponentName;
	}

	public Integer getNumberOfAgents() {
		return numberOfAgents;
	}

	public void setNumberOfAgents(Integer numberOfAgents) {
		this.numberOfAgents = numberOfAgents;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
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
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getTestName()).append(getGitRepoName())
				.append(getGitRepoURL()).append(getScriptName()).append(getEnv()).append(getUserid_users())
				.append(getTestType()).append(getNumberOfAgents()).append(getLobName()).append(getMnemonicName())
				.append(getAppComponentName()).append(getAvg_responsetime()).append(getAvg_tranpersec())
				.append(getErr_perc()).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof TestConfig) {
			TestConfig entity = (TestConfig) obj;
			return new EqualsBuilder().append(getId(), entity.getId()).append(getTestName(), entity.getTestName())
					.append(getGitRepoName(), entity.getGitRepoName()).append(getGitRepoURL(), entity.getGitRepoURL())
					.append(getScriptName(), entity.getScriptName()).append(getEnv(), entity.getEnv())
					.append(getUserid_users(), entity.getUserid_users()).append(getTestType(), entity.getTestType())
					.append(getNumberOfAgents(), entity.getNumberOfAgents()).append(getLobName(), entity.getLobName())
					.append(getMnemonicName(), entity.getMnemonicName())
					.append(getAppComponentName(), entity.getAppComponentName())
					.append(getAvg_responsetime(), entity.getAvg_responsetime())
					.append(getAvg_tranpersec(), entity.getAvg_tranpersec()).append(getErr_perc(), entity.getErr_perc())
					.build();
		} else {
			return false;
		}
	}
}
