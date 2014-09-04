package com.snks.mylection.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.snks.mylection.annotation.UniqueClassification;


@Entity
@Table(name="SUBJECT_CLASSIFICATIONS")
public class SubjectClassification {
	@Id @GeneratedValue
	private int subjectClassificationId;
	
	
	@UniqueClassification(message="This classification name already exists!")
	private String subjectClassificationName;

	@OneToMany(mappedBy="classification")
	private List<Subject> subjects = new ArrayList<Subject>();
	
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

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
