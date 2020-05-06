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
@Table(name = "mnemonic")
public class Mnemonic extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	private String id;

	@Column(name = "mnemonicsname")
	private String mnemonicsName;

	@ManyToOne
	@JoinColumn(name = "lobid", referencedColumnName = "id")
	private Lob lob;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
