package com.snks.mylection.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.snks.mylection.service.SubjectService;

public class UniqueSubjectNameValidator  implements ConstraintValidator<UniqueSubjectName,String>{
	 @Autowired
	    private SubjectService subjectService;

	@Override
	public void initialize(UniqueSubjectName constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(subjectService==null) {return true;}
		return subjectService.findByName(value)==null;
	}
	

}
