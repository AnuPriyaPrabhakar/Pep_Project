package com.ponsun.pep.relativeDetails.FamilyDocuments.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FamilyDocumentsRepository extends JpaRepository<FamilyDocuments, Integer> {

    Optional <FamilyDocuments> findById (Integer id);
}
