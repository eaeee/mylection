package com.snks.mylection.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class InitDbCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context,
			AnnotatedTypeMetadata metadata) {
		System.out.println(context.getEnvironment().toString());
		return true;
	}

}
