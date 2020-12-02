package com.project.common;

import com.project.annotation_custom.ValidateAgeAnnotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target({ FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValidateAgeAnnotation.class)
public @interface ValidateAge {

        String message() default "You not old enough to complete this form! ";

        Class<?>[] groups() default { };

        Class<? extends Payload>[] payload() default { };
}
