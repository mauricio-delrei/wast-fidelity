package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.repository;

import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity.BaptismRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataBaptismRepository
        extends JpaRepository<BaptismRecordEntity, UUID> {


    boolean existsByMemberId(UUID memberId);

}

