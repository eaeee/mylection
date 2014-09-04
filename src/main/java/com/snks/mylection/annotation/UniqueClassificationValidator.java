package com.snks.mylection.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.snks.mylection.service.SubjectClassificationService;

public class UniqueClassificationValidator implements ConstraintValidator<UniqueClassification,String> {
	
	 @Autowired
	 private SubjectClassificationService classificationService;

	@Override
	public void initialize(UniqueClassification constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(classificationService==null) return true;
		return classificationService.findByName(value)==null;
	}

}
