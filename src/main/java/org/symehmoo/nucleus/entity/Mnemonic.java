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
 * Table mapping to store mnemonic data
 */
@Entity
@Table(name = "mnemonic")
public class Mnemonic extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "mnemonicsname")
	private String mnemonicsName;

	@ManyToOne
	@JoinColumn(name = "lobid", referencedColumnName = "id")
	private Lob lob;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getMnemonicsName() {
		return mnemonicsName;
	}

	public void setMnemonicsName(String mnemonicsName) {
		this.mnemonicsName = mnemonicsName;
	}

	public Lob getLob() {
		return lob;
	}

	public void setLob(Lob lob) {
		this.lob = lob;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getMnemonicsName()).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof Mnemonic) {
			Mnemonic entity = (Mnemonic) obj;
			return new EqualsBuilder().append(getId(), entity.getId())
					.append(getMnemonicsName(), entity.getMnemonicsName()).build();
		} else {
			return false;
		}
	}
}
