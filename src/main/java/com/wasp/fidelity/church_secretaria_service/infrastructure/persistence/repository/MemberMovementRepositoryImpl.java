package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.repository;

import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberMovementRepository;
import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberMovementType;
import com.wasp.fidelity.church_secretaria_service.domain.model.MemberMovement;
import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity.MemberMovementEntity;
import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.mapper.MemberMovementPersistenceMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public class MemberMovementRepositoryImpl
        implements MemberMovementRepository {


    private final SpringDataMemberMovementRepository repository;

    private final MemberMovementPersistenceMapper mapper;



    public MemberMovementRepositoryImpl(
            SpringDataMemberMovementRepository repository,
            MemberMovementPersistenceMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }



    @Override
    public MemberMovement save(MemberMovement movement) {


        MemberMovementEntity entity =
                mapper.toEntity(movement);


        MemberMovementEntity saved =
                repository.save(entity);


        return movement;
    }
    @Override
    public boolean existsByMemberIdAndType(
            UUID memberId,
            MemberMovementType type
    ) {

        return repository.existsByMemberIdAndType(
                memberId,
                type
        );
    }
}
