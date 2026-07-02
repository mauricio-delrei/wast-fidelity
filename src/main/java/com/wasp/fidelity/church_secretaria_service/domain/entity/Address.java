package com.wasp.fidelity.church_secretaria_service.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @EqualsAndHashCode.Include
    private Long id;

    private String streetName;
    private String houseNumber;
    private String complement;
    private String city;
    private String county;
    private String postcode;
}
