package com.wasp.fidelity.church_secretaria_service.exception;

public class PhoneAlreadyExistsException extends BusinessRuleException {

    public PhoneAlreadyExistsException(String phone) {
        super("Mobile phone number is already registered: " + phone);
    }
}
