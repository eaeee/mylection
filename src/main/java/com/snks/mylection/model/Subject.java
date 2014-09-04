package com.snks.mylection.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.snks.mylection.annotation.UniqueSubjectName;

@Entity
@Table(name="SUBJECTS")
public class Subject {
	
	@Id @GeneratedValue
	private int subjectId;
	
	@UniqueSubjectName(message="This subjectname already exists!")
	private String subjectName;
	
	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	private SubjectClassification classification;
	
	public SubjectClassification getClassification() {
		return classification;
	}

	public void setClassification(SubjectClassification classification) {
		this.classification = classification;
	}

	public List<Lection> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Lection> subjects) {
		this.subjects = subjects;
	}

	@OneToMany(mappedBy="lectionSubject")
	private List<Lection> subjects = new ArrayList<Lection>();

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
