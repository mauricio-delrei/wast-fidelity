package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.repository;

import com.wasp.fidelity.church_secretaria_service.application.port.out.BaptismRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class BaptismRepositoryImpl implements BaptismRepository {

    private final SpringDataBaptismRepository repository;

    public BaptismRepositoryImpl(
            SpringDataBaptismRepository repository
    ){
        this.repository = repository;
    }


    @Override
    public boolean existsByMemberId(UUID memberId) {
        return repository.existsByMemberId(memberId);
    }
}
