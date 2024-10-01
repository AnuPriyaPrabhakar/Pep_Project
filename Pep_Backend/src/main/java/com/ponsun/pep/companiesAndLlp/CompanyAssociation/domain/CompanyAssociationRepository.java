package com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyAssociationRepository extends JpaRepository<CompanyAssociation,Integer> {

    Optional<CompanyAssociation> findById(Integer id);
    List<CompanyAssociation> findByCompanyId(Integer companyId);
}
