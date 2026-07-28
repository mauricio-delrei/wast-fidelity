package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity;

import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class MemberEntityPersistenceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void should_generate_audit_fields_when_member_is_created() {

        MemberEntity member = MemberEntity
                .builder()
                .fullName("Mauricio Del Rei")
                .email("mauriciodelrei@outlook.com")
                .status(MemberStatus.ACTIVE)
                .build();

        MemberEntity savedMember = entityManager.persistFlushFind(member);

        assertThat(savedMember.getCreatedAt())
                .isBeforeOrEqualTo(savedMember.getUpdatedAt());
        assertThat(savedMember.getUpdatedAt())
        .isNotNull();
        assertThat(savedMember.getStatus())
                .isEqualTo(MemberStatus.ACTIVE);


    }
}
