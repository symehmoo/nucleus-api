package org.symehmoo.nucleus.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Table mapping to store lob data
 */
@Entity
@Table(name = "lob")
public class Lob extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "lobname")
	private String lobName;

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
		return new HashCodeBuilder().append(getId()).append(getLobName()).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof Lob) {
			Lob entity = (Lob) obj;
			return new EqualsBuilder().append(getId(), entity.getId()).append(getLobName(), entity.getLobName())
					.build();
		} else {
			return false;
		}
	}
}
