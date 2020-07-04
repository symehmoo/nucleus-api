package org.symehmoo.nucleus.model;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Data object to return test execution details
 */
public class TestExecutionDTO {
	private UUID id;
	private String testName;
	private String runStatus;
	private Long processId;
	private BigDecimal avg_tranpersec;
	private BigDecimal avg_responsetime;
	private BigDecimal err_perc;
	private BigDecimal actual_avg_tranpersec;
	private BigDecimal actual_avg_responsetime;
	private BigDecimal actual_err_perc;
	private String testStatus;

	public TestExecutionDTO() {
		super();
	}

	public TestExecutionDTO(UUID id, String testName, String runStatus, Long processId, BigDecimal avg_tranpersec,
			BigDecimal avg_responsetime, BigDecimal err_perc, BigDecimal actual_avg_tranpersec,
			BigDecimal actual_avg_responsetime, BigDecimal actual_err_perc, String testStatus) {
		super();
		this.id = id;
		this.testName = testName;
		this.runStatus = runStatus;
		this.processId = processId;
		this.avg_tranpersec = avg_tranpersec;
		this.avg_responsetime = avg_responsetime;
		this.err_perc = err_perc;
		this.actual_avg_tranpersec = actual_avg_tranpersec;
		this.actual_avg_responsetime = actual_avg_responsetime;
		this.actual_err_perc = actual_err_perc;
		this.testStatus = testStatus;
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
	public String toString() {
		return "TestExecutionDTO [id=" + id + ", testName=" + testName + ", runStatus=" + runStatus + ", processId="
				+ processId + ", avg_tranpersec=" + avg_tranpersec + ", avg_responsetime=" + avg_responsetime
				+ ", err_perc=" + err_perc + ", actual_avg_tranpersec=" + actual_avg_tranpersec
				+ ", actual_avg_responsetime=" + actual_avg_responsetime + ", actual_err_perc=" + actual_err_perc
				+ ", testStatus=" + testStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actual_avg_responsetime == null) ? 0 : actual_avg_responsetime.hashCode());
		result = prime * result + ((actual_avg_tranpersec == null) ? 0 : actual_avg_tranpersec.hashCode());
		result = prime * result + ((actual_err_perc == null) ? 0 : actual_err_perc.hashCode());
		result = prime * result + ((avg_responsetime == null) ? 0 : avg_responsetime.hashCode());
		result = prime * result + ((avg_tranpersec == null) ? 0 : avg_tranpersec.hashCode());
		result = prime * result + ((err_perc == null) ? 0 : err_perc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((processId == null) ? 0 : processId.hashCode());
		result = prime * result + ((runStatus == null) ? 0 : runStatus.hashCode());
		result = prime * result + ((testName == null) ? 0 : testName.hashCode());
		result = prime * result + ((testStatus == null) ? 0 : testStatus.hashCode());
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
		TestExecutionDTO other = (TestExecutionDTO) obj;
		if (actual_avg_responsetime == null) {
			if (other.actual_avg_responsetime != null)
				return false;
		} else if (!actual_avg_responsetime.equals(other.actual_avg_responsetime))
			return false;
		if (actual_avg_tranpersec == null) {
			if (other.actual_avg_tranpersec != null)
				return false;
		} else if (!actual_avg_tranpersec.equals(other.actual_avg_tranpersec))
			return false;
		if (actual_err_perc == null) {
			if (other.actual_err_perc != null)
				return false;
		} else if (!actual_err_perc.equals(other.actual_err_perc))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (processId == null) {
			if (other.processId != null)
				return false;
		} else if (!processId.equals(other.processId))
			return false;
		if (runStatus == null) {
			if (other.runStatus != null)
				return false;
		} else if (!runStatus.equals(other.runStatus))
			return false;
		if (testName == null) {
			if (other.testName != null)
				return false;
		} else if (!testName.equals(other.testName))
			return false;
		if (testStatus == null) {
			if (other.testStatus != null)
				return false;
		} else if (!testStatus.equals(other.testStatus))
			return false;
		return true;
	}

}
