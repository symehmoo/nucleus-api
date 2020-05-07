package org.symehmoo.nucleus.model;

import java.util.UUID;

public class MnemonicDTO {
	private UUID id;
	private String mnemonicName;

	public MnemonicDTO() {
		super();
	}

	public MnemonicDTO(UUID id, String mnemonicName) {
		super();
		this.id = id;
		this.mnemonicName = mnemonicName;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mnemonicName == null) ? 0 : mnemonicName.hashCode());
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
		return true;
	}

	@Override
	public String toString() {
		return "MnemonicDTO [id=" + id + ", mnemonicName=" + mnemonicName + "]";
	}

}
