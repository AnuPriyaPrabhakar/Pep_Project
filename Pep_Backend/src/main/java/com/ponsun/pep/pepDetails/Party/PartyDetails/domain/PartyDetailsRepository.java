package com.ponsun.pep.pepDetails.Party.PartyDetails.domain;

import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PartyDetailsRepository extends JpaRepository<PartyDetails, Integer> {
    Optional<PartyDetails> findById(Integer id);

    List<PartyDetails> findByPepId(Integer pepId);

}