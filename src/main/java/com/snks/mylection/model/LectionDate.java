package com.snks.mylection.model;

import java.util.Date;

import javax.persistence.Embeddable;


@Embeddable
public class LectionDate {
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Date getAccessedDate() {
		return accessedDate;
	}
	public void setAccessedDate(Date accessedDate) {
		this.accessedDate = accessedDate;
	}
	private Date creationDate;
	private Date modifiedDate;
	private Date accessedDate;
}
