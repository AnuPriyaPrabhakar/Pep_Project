package com.ponsun.pep.spouse.spouseHuf.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SpouseHufRepository extends JpaRepository<SpouseHuf, Integer> {
    Optional<SpouseHuf> findById(Integer id);

}