package org.symehmoo.nucleus.model;

import java.util.UUID;

public class AppComponentsDTO {
	private UUID id;
	private String appComponentsName;

	public AppComponentsDTO() {
		super();
	}

	public AppComponentsDTO(UUID id, String appComponentsName) {
		super();
		this.id = id;
		this.appComponentsName = appComponentsName;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAppComponentsName() {
		return appComponentsName;
	}

	public void setAppComponentsName(String appComponentsName) {
		this.appComponentsName = appComponentsName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((appComponentsName == null) ? 0 : appComponentsName.hashCode());
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
		AppComponentsDTO other = (AppComponentsDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (appComponentsName == null) {
			if (other.appComponentsName != null)
				return false;
		} else if (!appComponentsName.equals(other.appComponentsName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppComponentsDTO [id=" + id + ", appComponentsName=" + appComponentsName + "]";
	}

}
