package com.wasp.fidelity.church_secretaria_service.exception;

public class EmailAlreadyExistsException extends BusinessRuleException {

    public EmailAlreadyExistsException(final String email) {
        super("Email address is already registered: " + email);
    }
}
