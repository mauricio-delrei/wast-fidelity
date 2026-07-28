package com.wasp.fidelity.church_secretaria_service;

import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.domain.model.Address;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@DataJpaTest
@ActiveProfiles("test")
class MemberPersistenceTest {

    @Autowired
    private MemberRepository repository;

    @Test
    void shouldSaveMemberWithAddress(){

        Address address = new Address(
                "High Street",
                "10",
                "London",
                "SW19 1AA",
                "UK",
                "Flat 2"
        );

        Member member = Member.create(
                "Mauricio Test",
                "mauricio@test.com",//
                "07123456789",
                LocalDate.of(1990, 1, 1),
                null,
                address
        );

        Member saved = repository.save(member);

        assertThat(saved).isNotNull();
        assertThat(saved.getEmail())
                .isEqualTo("mauricio@test.com");

        assertThat(saved.getAddress())
                .isNotNull();

        assertThat(saved.getAddress().street())
                .isEqualTo("High Street");


    }
}