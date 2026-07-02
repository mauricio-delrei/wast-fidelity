package com.wasp.fidelity.church_secretaria_service.exception;


    public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(Long id) {
        super("Member not found with id: " + id);
    }

}
