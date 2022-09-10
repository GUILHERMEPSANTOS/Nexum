package com.nexum.validation;

public class DomainExceptionValidation extends Exception {
    public DomainExceptionValidation(String error) {
        super(error);
    }

    public static void when(Boolean hasError, String error) throws DomainExceptionValidation {
        if (hasError) {
            throw new DomainExceptionValidation(error);
        }
    }
}
