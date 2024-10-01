package com.ponsun.pep.familyDetails.MotherDetails.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotherDetailsRepository extends JpaRepository<MotherDetails,Integer> {
    Optional<MotherDetails> findById(Integer id);
}