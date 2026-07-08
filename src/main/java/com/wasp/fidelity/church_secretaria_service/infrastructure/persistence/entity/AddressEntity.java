package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    private String city;

    private String postcode;

    private String country;

    private String complement;
}

