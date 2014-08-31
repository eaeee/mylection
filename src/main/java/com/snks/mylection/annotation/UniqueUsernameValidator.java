package com.snks.mylection.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.snks.mylection.service.UserService;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUserName, String> {
    @Autowired
    private UserService userService;

	@Override
	public void initialize(UniqueUserName constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(userService==null) {return true;}
		return userService.findByName(value) == null;
	}



}
