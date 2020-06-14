package org.symehmoo.nucleus.model;

import java.util.UUID;

/**
 * Data object to return mnemonic details
 */
public class MnemonicDTO {
	private UUID id;
	private String mnemonicName;
	private String lobName;

	public MnemonicDTO() {
		super();
	}

	public MnemonicDTO(UUID id, String mnemonicName, String lobName) {
		super();
		this.id = id;
		this.mnemonicName = mnemonicName;
		this.lobName = lobName;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		MnemonicDTO other = (MnemonicDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
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
		return "MnemonicDTO [id=" + id + ", mnemonicName=" + mnemonicName + ", lobName=" + lobName + "]";
	}

}
