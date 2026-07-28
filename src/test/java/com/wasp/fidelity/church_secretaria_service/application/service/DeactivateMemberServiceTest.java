package com.wasp.fidelity.church_secretaria_service.application.service;

import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberStatus;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.exception.MemberNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DeactivateMemberServiceTest {

    private MemberRepository repository;

    private DeactivateMemberService service;


    @BeforeEach
    void setup(){
        repository = mock(MemberRepository.class);
        service = new DeactivateMemberService(repository);

    }
    @Test
    void should_deactivate_member_successfully() {

        UUID memberId = UUID.randomUUID();


        Member member = Member.create(
                "Mauricio Del Rei",
                "mauricio@test.com",
                "+447700000000",
                null,
                null,
                null
        );


        when(repository.findById(memberId))
                .thenReturn(Optional.of(member));


        when(repository.save(any(Member.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));


        Member result = service.execute(memberId);


        assertThat(result.getStatus())
                .isEqualTo(com.wasp.fidelity.church_secretaria_service.domain.enums.MemberStatus.INACTIVE);


        assertThat(result.getDeactivatedAt())
                .isNotNull();


        verify(repository)
                .findById(memberId);


        verify(repository)
                .save(any(Member.class));
    }
    @Test
    void should_throw_exception_when_member_not_found() {

        UUID memberId = UUID.randomUUID();


        when(repository.findById(memberId))
                .thenReturn(Optional.empty());


        assertThrows(
                MemberNotFoundException.class,
                () -> service.execute(memberId)
        );


        verify(repository)
                .findById(memberId);


        verify(repository, never())
                .save(any());
    }
    @Test
    void should_not_change_already_inactive_member() {

        UUID memberId = UUID.randomUUID();

        Member member = Member.create(
                "Mauricio Del Rei",
                "mauricio@test.com",
                "+447700000000",
                null,
                null,
                null
        );

        Member inactiveMember = member.deactivate();


        when(repository.findById(memberId))
                .thenReturn(Optional.of(inactiveMember));


        when(repository.save(any(Member.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));


        Member result = service.execute(memberId);


        assertThat(result.getStatus())
                .isEqualTo(MemberStatus.INACTIVE);


        assertThat(result.getDeactivatedAt())
                .isEqualTo(inactiveMember.getDeactivatedAt());


        verify(repository)
                .save(any(Member.class));
    }


}
