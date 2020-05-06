package org.symehmoo.nucleus.entity;

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

@Entity
@Table(name = "appcomponents")
public class AppComponents extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	private String id;

	@Column(name = "appcomponentsname")
	private String appComponentsName;

	@ManyToOne
	@JoinColumn(name = "mnemonicid", referencedColumnName = "id")
	private Mnemonic mnemonic;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppComponentsName() {
		return appComponentsName;
	}

	public void setAppComponentsName(String appComponentsName) {
		this.appComponentsName = appComponentsName;
	}

	public Mnemonic getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(Mnemonic mnemonic) {
		this.mnemonic = mnemonic;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getAppComponentsName()).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof AppComponents) {
			AppComponents entity = (AppComponents) obj;
			return new EqualsBuilder().append(getId(), entity.getId())
					.append(getAppComponentsName(), entity.getAppComponentsName()).build();
		} else {
			return false;
		}
	}
}
