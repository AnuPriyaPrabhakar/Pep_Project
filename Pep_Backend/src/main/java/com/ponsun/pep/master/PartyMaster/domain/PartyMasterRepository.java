package com.ponsun.pep.master.PartyMaster.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface PartyMasterRepository extends JpaRepository<PartyMaster,Integer>, JpaSpecificationExecutor<PartyMaster> {
    Optional<PartyMaster> findById(Integer id);
}