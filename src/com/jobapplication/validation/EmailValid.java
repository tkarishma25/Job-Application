package com.jobapplication.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD,ElementType.FIELD}) 
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidValidator.class)
//@Documented
public @interface EmailValid {
	String message() default "Invalid email id";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
