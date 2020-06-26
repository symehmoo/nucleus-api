package org.symehmoo.nucleus.entity;

import java.util.UUID;

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
import org.hibernate.annotations.Type;

/**
 * Table mapping to store app component data
 */
@Entity
@Table(name = "appcomponents")
public class AppComponents extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "appcomponentsname")
	private String appComponentsName;

	@ManyToOne
	@JoinColumn(name = "mnemonicid", referencedColumnName = "id")
	private Mnemonic mnemonic;

	@Column(name = "mnemonicname")
	private String mnemonicName;

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

	public Mnemonic getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(Mnemonic mnemonic) {
		this.mnemonic = mnemonic;
	}

	public String getMnemonicName() {
		return mnemonicName;
	}

	public void setMnemonicName(String mnemonicName) {
		this.mnemonicName = mnemonicName;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getAppComponentsName()).append(getMnemonicName()).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof AppComponents) {
			AppComponents entity = (AppComponents) obj;
			return new EqualsBuilder().append(getId(), entity.getId())
					.append(getAppComponentsName(), entity.getAppComponentsName())
					.append(getMnemonicName(), entity.getMnemonicName()).build();
		} else {
			return false;
		}
	}
}
