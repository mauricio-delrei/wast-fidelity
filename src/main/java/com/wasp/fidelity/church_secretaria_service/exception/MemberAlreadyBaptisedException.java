package com.wasp.fidelity.church_secretaria_service.exception;

public class MemberAlreadyBaptisedException extends BusinessRuleException {

    public MemberAlreadyBaptisedException() {
        super("Member has already been baptised.");
    }
}
