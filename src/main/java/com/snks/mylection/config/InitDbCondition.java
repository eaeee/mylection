package com.snks.mylection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;


@Configuration
@PropertySource({ "classpath:hibernate-mysql.properties" })
public class InitDbCondition implements Condition {
	
	   @Autowired
	   private Environment env;
	@Override
	public boolean matches(ConditionContext context,
			AnnotatedTypeMetadata metadata) {
		System.out.println(context.getEnvironment().toString());
		return true;
	}

}
