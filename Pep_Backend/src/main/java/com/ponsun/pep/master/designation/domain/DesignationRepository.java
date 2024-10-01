package com.ponsun.pep.master.designation.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DesignationRepository extends JpaRepository<Designation, Integer> {
    Optional<Designation> findById(Integer id);


}