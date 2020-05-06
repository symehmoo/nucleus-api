package org.symehmoo.nucleus.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	@CreatedDate
	@Column(updatable = false, name = "datecreated")
	private Date dateCreated;

	@LastModifiedDate
	@Column(name = "datemodified")
	private Date dateModified;

	public Date getDateCreated() {
		return this.dateCreated == null ? null : new Date(this.dateCreated.getTime());
	}

	public Date getDateModified() {
		return this.dateModified == null ? null : new Date(this.dateModified.getTime());
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated == null ? null : new Date(dateCreated.getTime());
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified == null ? null : new Date(dateModified.getTime());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDateCreated()).append(getDateModified()).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof BaseEntity) {
			BaseEntity entity = (BaseEntity) obj;
			return new EqualsBuilder().append(getDateCreated(), entity.getDateCreated())
					.append(getDateModified(), entity.getDateModified()).build();
		} else {
			return false;
		}
	}
}