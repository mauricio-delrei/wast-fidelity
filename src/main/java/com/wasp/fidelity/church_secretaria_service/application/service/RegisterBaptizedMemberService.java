package com.wasp.fidelity.church_secretaria_service.application.service;

import com.wasp.fidelity.church_secretaria_service.application.command.RegisterBaptizedMemberCommand;
import com.wasp.fidelity.church_secretaria_service.application.port.in.RegisterBaptizedMemberUseCase;
import com.wasp.fidelity.church_secretaria_service.application.port.out.BaptismRepository;
import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberMovementRepository;
import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.domain.model.MemberMovement;
import com.wasp.fidelity.church_secretaria_service.exception.EmailAlreadyExistsException;
import com.wasp.fidelity.church_secretaria_service.exception.MemberAlreadyBaptisedException;
import com.wasp.fidelity.church_secretaria_service.exception.PhoneAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class RegisterBaptizedMemberService
        implements RegisterBaptizedMemberUseCase {


    private final MemberRepository memberRepository;

    private final BaptismRepository baptismRepository;

    private final MemberMovementRepository movementRepository;



    public RegisterBaptizedMemberService(
            MemberRepository memberRepository,
            BaptismRepository baptismRepository,
            MemberMovementRepository movementRepository
    ) {
        this.memberRepository = memberRepository;
        this.baptismRepository = baptismRepository;
        this.movementRepository = movementRepository;
    }

    private void validateEmail(String email) {

        memberRepository.findByEmail(email)
                .ifPresent(member -> {
                    throw new EmailAlreadyExistsException(email);
                });
    }
    private void validatePhone(String phone) {

        memberRepository.findByMobilePhone(phone)
                .ifPresent(member -> {
                    throw new PhoneAlreadyExistsException(phone);
                });
    }




    @Override
    public Member execute(RegisterBaptizedMemberCommand command) {

        validateEmail(command.getEmail());

        validatePhone(command.getMobilePhone());


        Member member = Member.create(
                command.getFullName(),
                command.getEmail(),
                command.getMobilePhone(),
                command.getDateOfBirth(),
                command.getBaptismDate(),
                command.getAddress()
        );


        Member savedMember = memberRepository.save(member);

        if(baptismRepository.existsByMemberId(savedMember.getId())){
            throw new MemberAlreadyBaptisedException();
        }



        MemberMovement movement =
                MemberMovement.baptism(savedMember.getId());

        movementRepository.save(movement);

        return savedMember;
    }
}
