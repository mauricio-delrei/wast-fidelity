package com.wasp.fidelity.church_secretaria_service.integration;

import com.wasp.fidelity.church_secretaria_service.application.command.RegisterBaptizedMemberCommand;
import com.wasp.fidelity.church_secretaria_service.application.port.in.RegisterBaptizedMemberUseCase;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity.MemberMovementEntity;
import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.repository.SpringDataMemberMovementRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
@ActiveProfiles("test")
public class RegisterBaptizedMemberIntegrationTest {

    @Container
    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:16")
                    .withDatabaseName("church_db")
                    .withUsername("church_user")
                    .withPassword("church_pass");


    @DynamicPropertySource
    static void configureDatabase(
            DynamicPropertyRegistry registry
    ) {

        registry.add(
                "spring.datasource.url",
                postgres::getJdbcUrl
        );

        registry.add(
                "spring.datasource.username",
                postgres::getUsername
        );

        registry.add(
                "spring.datasource.password",
                postgres::getPassword
        );

    }


    @Autowired
    private RegisterBaptizedMemberUseCase useCase;


    @Autowired
    private SpringDataMemberMovementRepository movementRepository;


    @Test
    void should_register_baptized_member_and_create_movement() {


        RegisterBaptizedMemberCommand command =
                RegisterBaptizedMemberCommand.builder()
                        .fullName("Integration Test Member")
                        .email("integration@test.com")
                        .mobilePhone("+447700000000")
                        .dateOfBirth(
                                LocalDate.of(1990, 1, 1)
                        )
                        .baptismDate(
                                LocalDate.now()
                        )
                        .build();


        Member member =
                useCase.execute(command);


        assertThat(member.getId())
                .isNotNull();


        var movements =
                movementRepository.findAll();


        assertThat(movements)
                .hasSize(1);


        MemberMovementEntity movement =
                movements.get(0);


        assertThat(movement.getType().name())
                .isEqualTo("BAPTISM");

    }
}
