package com.quynhlm.dev.be.core.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CapitalizedValidator implements ConstraintValidator<CapitalizedConstraint, String> {
    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (str.isEmpty() || str == null) return Boolean.FALSE;
        if (!Character.isUpperCase(str.charAt(0))) return Boolean.FALSE;

        return Boolean.TRUE;
    }
}
