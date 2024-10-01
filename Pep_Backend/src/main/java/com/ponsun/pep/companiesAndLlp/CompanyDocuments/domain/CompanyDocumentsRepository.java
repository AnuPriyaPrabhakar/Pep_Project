package com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyDocumentsRepository extends JpaRepository<CompanyDocuments, Integer> {

    Optional<CompanyDocuments> findById (Integer id);
}