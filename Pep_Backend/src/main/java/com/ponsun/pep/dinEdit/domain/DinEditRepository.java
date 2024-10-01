package com.ponsun.pep.dinEdit.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DinEditRepository extends JpaRepository<DinEdit,Integer> {
    Optional<DinEdit> findById(Integer id);
}
