package com.snks.mylection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="SUBJECT_CLASSIFICATIONS")
public class SubjectClassification {
	@Id @GeneratedValue
	private int subjectClassificationId;
	
	private String subjectClassificationName;

	
	
	
	
	
	
	public String getSubjectClassificationName() {
		return subjectClassificationName;
	}

	public void setSubjectClassificationName(String subjectClassificationName) {
		this.subjectClassificationName = subjectClassificationName;
	}

	public int getSubjectClassificationId() {
		return subjectClassificationId;
	}

	public void setSubjectClassificationId(int subjectClassificationId) {
		this.subjectClassificationId = subjectClassificationId;
	}

}
