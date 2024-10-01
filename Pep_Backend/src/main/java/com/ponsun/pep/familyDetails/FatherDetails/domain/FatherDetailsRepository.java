package com.ponsun.pep.familyDetails.FatherDetails.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FatherDetailsRepository  extends JpaRepository<FatherDetails,Integer> {
    @Override
    Optional<FatherDetails> findById(Integer id);
}
