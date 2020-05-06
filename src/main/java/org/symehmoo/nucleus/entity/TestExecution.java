package org.symehmoo.nucleus.entity;

import java.util.Date;

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
public class TestExecution extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	private String id;

	@Column(name = "startTime")
	private Date startTime;

	@Column(name = "endTime")
	private Date endTime;

	@Column(name = "runstatus")
	private String runStatus;

	@Column(name = "processid")
	private Integer processId;

	@Column(name = "users_idusers")
	private String users_idusers;

	@ManyToOne
	@JoinColumn(name = "testconfigid", referencedColumnName = "id")
	private TestConfig testConfig;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartTime() {
		return this.startTime == null ? null : new Date(this.startTime.getTime());
	}

	public Date getEndTime() {
		return this.endTime == null ? null : new Date(this.endTime.getTime());
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime == null ? null : new Date(startTime.getTime());
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime == null ? null : new Date(endTime.getTime());
	}

	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public String getUsers_idusers() {
		return users_idusers;
	}

	public void setUsers_idusers(String users_idusers) {
		this.users_idusers = users_idusers;
	}

	public TestConfig getTestConfig() {
		return testConfig;
	}

	public void setTestConfig(TestConfig testConfig) {
		this.testConfig = testConfig;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getStartTime()).append(getEndTime()).append(getRunStatus())
				.append(getProcessId()).append(getUsers_idusers()).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof TestExecution) {
			TestExecution entity = (TestExecution) obj;
			return new EqualsBuilder().append(getId(), entity.getId()).append(getStartTime(), entity.getStartTime())
					.append(getEndTime(), entity.getEndTime()).append(getRunStatus(), entity.getRunStatus())
					.append(getProcessId(), entity.getProcessId()).append(getUsers_idusers(), entity.getUsers_idusers())
					.build();
		} else {
			return false;
		}
	}
}
