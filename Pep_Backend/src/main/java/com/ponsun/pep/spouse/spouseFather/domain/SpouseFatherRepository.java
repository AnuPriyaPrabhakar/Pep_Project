package com.ponsun.pep.spouse.spouseFather.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SpouseFatherRepository extends JpaRepository<SpouseFather, Integer> {
    Optional<SpouseFather> findById(Integer id);

}