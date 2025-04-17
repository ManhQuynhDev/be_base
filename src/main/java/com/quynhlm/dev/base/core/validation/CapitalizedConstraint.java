package com.quynhlm.dev.base.core.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CapitalizedValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CapitalizedConstraint {
    String message() default "First letter must be a upper case letter!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
