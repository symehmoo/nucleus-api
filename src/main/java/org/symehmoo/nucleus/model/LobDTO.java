package org.symehmoo.nucleus.model;

import java.util.UUID;

/**
 * Data object to return lob details
 */
public class LobDTO {
	private UUID id;
	private String lobName;

	public LobDTO() {
		super();
	}

	public LobDTO(UUID id, String lobName) {
		super();
		this.id = id;
		this.lobName = lobName;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
		LobDTO other = (LobDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "LobDTO [id=" + id + ", lobName=" + lobName + "]";
	}

}
