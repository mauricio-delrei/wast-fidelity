package com.wasp.fidelity.church_secretaria_service.domain.model;

import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberTest {

    @Test
    void should_create_member_with_active_status() {
        Member member = Member.create(
                "Mauricio Del Rei",
                "mauricio@test.com",
                "+447700000000",
                null,
                null,
                null
        );
        assertThat(member.getFullName())
                .isEqualTo("Mauricio Del Rei");


        assertThat(member.getEmail())
                .isEqualTo("mauricio@test.com");


        assertThat(member.getStatus())
                .isEqualTo(MemberStatus.ACTIVE);


        assertThat(member.getDeactivatedAt())
                .isNull();

    }

    @Test
    void should_deactivate_member() {

        Member member = Member.create(
                "Mauricio Del Rei",
                "mauricio@test.com",
                "+447700000000",
                null,
                null,
                null
        );
        Member deactivatedMember = member.deactivate();


        assertThat(deactivatedMember.getStatus())
                .isEqualTo(MemberStatus.INACTIVE);


        assertThat(deactivatedMember.getDeactivatedAt())
                .isNotNull();
    }

    @Test
    void should_activate_member() {

        Member member = Member.create(
                "Mauricio Del Rei",
                "mauricio@test.com",
                "+447700000000",
                null,
                null,
                null
        );


        Member inactiveMember = member.deactivate();


        Member activatedMember = inactiveMember.activate();


        assertThat(activatedMember.getStatus())
                .isEqualTo(MemberStatus.ACTIVE);


        assertThat(activatedMember.getDeactivatedAt())
                .isNull();
    }
    @Test
    void should_keep_original_member_when_deactivated() {

        Member member = Member.create(
                "Mauricio Del Rei",
                "mauricio@test.com",
                "+447700000000",
                null,
                null,
                null
        );


        Member inactive = member.deactivate();


        assertThat(member.getStatus())
                .isEqualTo(MemberStatus.ACTIVE);


        assertThat(inactive.getStatus())
                .isEqualTo(MemberStatus.INACTIVE);
    }
}
