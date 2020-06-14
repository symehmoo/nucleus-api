package org.symehmoo.nucleus.model;

/**
 * Data object used while saving mnemonic
 */
public class MnemonicSaveDTO {
	private String mnemonicName;
	private String lobName;

	public MnemonicSaveDTO() {
		super();
	}

	public MnemonicSaveDTO(String mnemonicName, String lobName) {
		super();
		this.mnemonicName = mnemonicName;
		this.lobName = lobName;
	}

	public String getMnemonicName() {
		return mnemonicName;
	}

	public void setMnemonicName(String mnemonicName) {
		this.mnemonicName = mnemonicName;
	}

	public String getLobName() {
		return lobName;
	}

	public void setLobName(String lobName) {
		this.lobName = lobName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mnemonicName == null) ? 0 : mnemonicName.hashCode());
		result = prime * result + ((lobName == null) ? 0 : lobName.hashCode());
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
		MnemonicSaveDTO other = (MnemonicSaveDTO) obj;
		if (mnemonicName == null) {
			if (other.mnemonicName != null)
				return false;
		} else if (!mnemonicName.equals(other.mnemonicName))
			return false;
		if (lobName == null) {
			if (other.lobName != null)
				return false;
		} else if (!lobName.equals(other.lobName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MnemonicDTO [mnemonicName=" + mnemonicName + ", lobName=" + lobName + "]";
	}

}
