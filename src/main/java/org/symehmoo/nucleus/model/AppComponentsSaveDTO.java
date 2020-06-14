package org.symehmoo.nucleus.model;

/**
 * Data object used for saving appcomponent
 */
public class AppComponentsSaveDTO {
	private String appComponentsName;
	private String mnemonicName;

	public AppComponentsSaveDTO() {
		super();
	}

	public AppComponentsSaveDTO(String appComponentsName, String mnemonicName) {
		super();
		this.appComponentsName = appComponentsName;
		this.mnemonicName = mnemonicName;
	}

	public String getAppComponentsName() {
		return appComponentsName;
	}

	public void setAppComponentsName(String appComponentsName) {
		this.appComponentsName = appComponentsName;
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
		result = prime * result + ((appComponentsName == null) ? 0 : appComponentsName.hashCode());
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
		AppComponentsSaveDTO other = (AppComponentsSaveDTO) obj;
		if (appComponentsName == null) {
			if (other.appComponentsName != null)
				return false;
		} else if (!appComponentsName.equals(other.appComponentsName))
			return false;
		if (mnemonicName == null) {
			if (other.mnemonicName != null)
				return false;
		} else if (!mnemonicName.equals(other.mnemonicName))
			return false;
		return true;
	}

}