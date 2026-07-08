package com.wasp.fidelity.church_secretaria_service.domain.model;

import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberStatus;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Member {

    private final UUID id;
    private final String fullName;
    private final String email;
    private final String mobilePhone;
    private final LocalDate dateOfBirth;
    private final LocalDate baptismDate;
    private final MemberStatus status;
    private final Address address;
    private final LocalDateTime deactivatedAt;


    private Member(Builder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.mobilePhone = builder.mobilePhone;
        this.dateOfBirth = builder.dateOfBirth;
        this.baptismDate = builder.baptismDate;
        this.status = builder.status != null
                ? builder.status
                : MemberStatus.ACTIVE;
        this.address = builder.address;
        this.deactivatedAt = builder.deactivatedAt;
    }


    public static Builder builder() {
        return new Builder();
    }


    public static Member create(
            String fullName,
            String email,
            String mobilePhone,
            LocalDate dateOfBirth,
            LocalDate baptismDate,
            Address address
    ) {

        return builder()
                .id(UUID.randomUUID())
                .fullName(fullName)
                .email(email)
                .mobilePhone(mobilePhone)
                .dateOfBirth(dateOfBirth)
                .baptismDate(baptismDate)
                .status(MemberStatus.ACTIVE)
                .address(address)
                .build();
    }


    public Member deactivate() {

        if (this.status == MemberStatus.INACTIVE && this.deactivatedAt != null) {
            return this;
        }

        return builder()
                .id(this.id)
                .fullName(this.fullName)
                .email(this.email)
                .mobilePhone(this.mobilePhone)
                .dateOfBirth(this.dateOfBirth)
                .baptismDate(this.baptismDate)
                .status(MemberStatus.INACTIVE)
                .deactivatedAt(
                        this.deactivatedAt != null
                                ? this.deactivatedAt
                                : LocalDateTime.now()
                )
                .address(this.address)
                .build();
    }


    public Member activate() {

        if (this.status == MemberStatus.ACTIVE) {
            return this;
        }

        return builder()
                .id(this.id)
                .fullName(this.fullName)
                .email(this.email)
                .mobilePhone(this.mobilePhone)
                .dateOfBirth(this.dateOfBirth)
                .baptismDate(this.baptismDate)
                .status(MemberStatus.ACTIVE)
                .deactivatedAt(null)
                .address(this.address)
                .build();
    }


    public Member update(
            String fullName,
            String email,
            String mobilePhone,
            LocalDate dateOfBirth,
            LocalDate baptismDate,
            MemberStatus status,
            Address address
    ) {

        return builder()
                .id(this.id)
                .fullName(fullName != null ? fullName : this.fullName)
                .email(email != null ? email : this.email)
                .mobilePhone(mobilePhone != null ? mobilePhone : this.mobilePhone)
                .dateOfBirth(dateOfBirth != null ? dateOfBirth : this.dateOfBirth)
                .baptismDate(baptismDate != null ? baptismDate : this.baptismDate)
                .status(status != null ? status : this.status)
                .deactivatedAt(this.deactivatedAt)
                .address(address != null ? address : this.address)
                .build();
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Member member)) {
            return false;
        }

        return Objects.equals(id, member.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public static class Builder {

        private UUID id;
        private String fullName;
        private String email;
        private String mobilePhone;
        private LocalDate dateOfBirth;
        private LocalDate baptismDate;
        private MemberStatus status;
        private Address address;
        private LocalDateTime deactivatedAt;


        public Builder id(UUID id) {
            this.id = id;
            return this;
        }


        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }


        public Builder email(String email) {
            this.email = email;
            return this;
        }


        public Builder mobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }


        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }


        public Builder baptismDate(LocalDate baptismDate) {
            this.baptismDate = baptismDate;
            return this;
        }


        public Builder status(MemberStatus status) {
            this.status = status;
            return this;
        }


        public Builder address(Address address) {
            this.address = address;
            return this;
        }


        public Builder deactivatedAt(LocalDateTime deactivatedAt) {
            this.deactivatedAt = deactivatedAt;
            return this;
        }


        public Member build() {
            return new Member(this);
        }
    }
}