package org.symehmoo.nucleus.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "lobid", referencedColumnName = "id")
	private Lob lob;

	@ManyToOne
	@JoinColumn(name = "mnemonicid", referencedColumnName = "id")
	private Mnemonic mnemonic;

	@ManyToOne
	@JoinColumn(name = "appcomponentsid", referencedColumnName = "id")
	private AppComponents appComponents;

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

	public Lob getLob() {
		return lob;
	}

	public void setLob(Lob lob) {
		this.lob = lob;
	}

	public Mnemonic getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(Mnemonic mnemonic) {
		this.mnemonic = mnemonic;
	}

	public AppComponents getAppComponents() {
		return appComponents;
	}

	public void setAppComponents(AppComponents appComponents) {
		this.appComponents = appComponents;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getTestName()).append(getGitRepoName())
				.append(getGitRepoURL()).append(getScriptName()).append(getEnv()).append(getUserid_users())
				.append(getTestType()).append(getNumberOfAgents()).build();
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
					.append(getNumberOfAgents(), entity.getNumberOfAgents()).build();
		} else {
			return false;
		}
	}
}
