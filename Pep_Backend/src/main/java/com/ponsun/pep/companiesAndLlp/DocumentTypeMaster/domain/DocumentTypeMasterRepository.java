package com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentTypeMasterRepository extends JpaRepository<DocumentTypeMaster,Integer> {

    Optional<DocumentTypeMaster> findById(Integer id);
}
