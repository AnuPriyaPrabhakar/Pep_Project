package com.ponsun.pep.spouse.spouseMother.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SpouseMotherRepository extends JpaRepository<SpouseMother, Integer> {
    Optional<SpouseMother> findById(Integer id);

}