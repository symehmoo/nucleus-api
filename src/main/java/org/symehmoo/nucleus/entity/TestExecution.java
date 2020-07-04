package org.symehmoo.nucleus.entity;

import java.math.BigDecimal;
import java.util.Date;
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
 * Table mapping to store test execution data
 */
@Entity
@Table(name = "testexecution")
public class TestExecution extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "starttime")
	private Date startTime;

	@Column(name = "endtime")
	private Date endTime;

	@Column(name = "runstatus")
	private String runStatus;

	@Column(name = "processid")
	private Long processId;

	@Column(name = "userid_users")
	private String userid_users;

	@ManyToOne
	@JoinColumn(name = "testconfigid", referencedColumnName = "id")
	private TestConfig testConfig;

	@Column(name = "avg_tranpersec")
	private BigDecimal avg_tranpersec;

	@Column(name = "avg_responsetime")
	private BigDecimal avg_responsetime;

	@Column(name = "err_perc")
	private BigDecimal err_perc;

	@Column(name = "actual_avg_tranpersec")
	private BigDecimal actual_avg_tranpersec;

	@Column(name = "actual_avg_responsetime")
	private BigDecimal actual_avg_responsetime;

	@Column(name = "actual_err_perc")
	private BigDecimal actual_err_perc;

	@Column(name = "teststatus")
	private String testStatus;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

	public String getUserid_users() {
		return userid_users;
	}

	public void setUserid_users(String userid_users) {
		this.userid_users = userid_users;
	}

	public TestConfig getTestConfig() {
		return testConfig;
	}

	public void setTestConfig(TestConfig testConfig) {
		this.testConfig = testConfig;
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

	public BigDecimal getActual_avg_tranpersec() {
		return actual_avg_tranpersec;
	}

	public void setActual_avg_tranpersec(BigDecimal actual_avg_tranpersec) {
		this.actual_avg_tranpersec = actual_avg_tranpersec;
	}

	public BigDecimal getActual_avg_responsetime() {
		return actual_avg_responsetime;
	}

	public void setActual_avg_responsetime(BigDecimal actual_avg_responsetime) {
		this.actual_avg_responsetime = actual_avg_responsetime;
	}

	public BigDecimal getActual_err_perc() {
		return actual_err_perc;
	}

	public void setActual_err_perc(BigDecimal actual_err_perc) {
		this.actual_err_perc = actual_err_perc;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getStartTime()).append(getEndTime()).append(getRunStatus())
				.append(getProcessId()).append(getUserid_users()).append(getAvg_responsetime())
				.append(getAvg_tranpersec()).append(getErr_perc()).append(getActual_avg_responsetime())
				.append(getActual_avg_tranpersec()).append(getActual_err_perc()).append(getTestStatus()).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof TestExecution) {
			TestExecution entity = (TestExecution) obj;
			return new EqualsBuilder().append(getId(), entity.getId()).append(getStartTime(), entity.getStartTime())
					.append(getEndTime(), entity.getEndTime()).append(getRunStatus(), entity.getRunStatus())
					.append(getProcessId(), entity.getProcessId()).append(getUserid_users(), entity.getUserid_users())
					.append(getAvg_responsetime(), entity.getAvg_responsetime())
					.append(getAvg_tranpersec(), entity.getAvg_tranpersec()).append(getErr_perc(), entity.getErr_perc())
					.append(getActual_avg_responsetime(), entity.getActual_avg_responsetime())
					.append(getActual_avg_tranpersec(), entity.getActual_avg_tranpersec())
					.append(getActual_err_perc(), entity.getActual_err_perc())
					.append(getTestStatus(), entity.getTestStatus()).build();
		} else {
			return false;
		}
	}
}
