package com.ponsun.pep.master.Country.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface CountryRepository extends JpaRepository<Country, Integer> {
    Optional<Country> findById(Integer id);

}