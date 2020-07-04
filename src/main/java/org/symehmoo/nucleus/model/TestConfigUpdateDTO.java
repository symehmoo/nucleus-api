package org.symehmoo.nucleus.model;

import java.math.BigDecimal;

/**
 * Data object used to update test config record
 */
public class TestConfigUpdateDTO {
	private String testName;
	private String scriptName;
	private Integer numberOfAgents;
	private BigDecimal avg_tranpersec;
	private BigDecimal avg_responsetime;
	private BigDecimal err_perc;

	public TestConfigUpdateDTO() {
		super();
	}

	public TestConfigUpdateDTO(String testName, String scriptName, Integer numberOfAgents, BigDecimal avg_tranpersec,
			BigDecimal avg_responsetime, BigDecimal err_perc) {
		super();
		this.testName = testName;
		this.scriptName = scriptName;
		this.numberOfAgents = numberOfAgents;
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

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
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
		return "TestConfigUpdateDTO [testName=" + testName + ", scriptName=" + scriptName + ", numberOfAgents="
				+ numberOfAgents + ", avg_tranpersec=" + avg_tranpersec + ", avg_responsetime=" + avg_responsetime
				+ ", err_perc=" + err_perc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avg_responsetime == null) ? 0 : avg_responsetime.hashCode());
		result = prime * result + ((avg_tranpersec == null) ? 0 : avg_tranpersec.hashCode());
		result = prime * result + ((err_perc == null) ? 0 : err_perc.hashCode());
		result = prime * result + ((numberOfAgents == null) ? 0 : numberOfAgents.hashCode());
		result = prime * result + ((scriptName == null) ? 0 : scriptName.hashCode());
		result = prime * result + ((testName == null) ? 0 : testName.hashCode());
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
		TestConfigUpdateDTO other = (TestConfigUpdateDTO) obj;
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
		if (numberOfAgents == null) {
			if (other.numberOfAgents != null)
				return false;
		} else if (!numberOfAgents.equals(other.numberOfAgents))
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
		return true;
	}
}
