package org.symehmoo.nucleus.model;

/**
 * Data object used while saving lob
 */
public class LobSaveDTO {
	private String lobName;

	public LobSaveDTO() {
		super();
	}

	public LobSaveDTO(String lobName) {
		super();
		this.lobName = lobName;
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
		LobSaveDTO other = (LobSaveDTO) obj;
		if (lobName == null) {
			if (other.lobName != null)
				return false;
		} else if (!lobName.equals(other.lobName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LobDTO [lobName=" + lobName + "]";
	}

}
