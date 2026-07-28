package com.wasp.fidelity.church_secretaria_service.exception;

public class AlreadyBaptizedElsewhereException extends BusinessRuleException {

    public AlreadyBaptizedElsewhereException() {
        super("This member has already been baptised at another institution.");
    }
}
