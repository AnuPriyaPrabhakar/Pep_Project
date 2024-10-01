package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompaniesDirectorsRepository extends JpaRepository<CompaniesDirectors,Integer>  {

    Optional<CompaniesDirectors> findById(Integer id);

    List<CompaniesDirectors> findByCompanyId(Integer companyId);
}
