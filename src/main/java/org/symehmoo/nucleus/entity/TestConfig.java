package org.symehmoo.nucleus.entity;

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

@Entity
@Table(name = "testconfig")
public class TestConfig extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	private String id;

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

	@Column(name = "users_idusers")
	private String users_idusers;

	@ManyToOne
	@JoinColumn(name = "lobid", referencedColumnName = "id")
	private Lob lob;

	@ManyToOne
	@JoinColumn(name = "mnemonicId", referencedColumnName = "id")
	private Mnemonic mnemonic;

	@ManyToOne
	@JoinColumn(name = "appcomponentsid", referencedColumnName = "id")
	private AppComponents appComponents;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getUsers_idusers() {
		return users_idusers;
	}

	public void setUsers_idusers(String users_idusers) {
		this.users_idusers = users_idusers;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getTestName()).append(getGitRepoName())
				.append(getGitRepoURL()).append(getScriptName()).append(getEnv()).append(getUsers_idusers()).build();
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
					.append(getUsers_idusers(), entity.getUsers_idusers()).build();
		} else {
			return false;
		}
	}
}
