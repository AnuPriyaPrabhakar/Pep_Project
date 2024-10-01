package com.ponsun.pep.RequestDescription.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestDescriptionRepository extends JpaRepository<RequestDescription,Integer> {
    Optional<RequestDescription> findById(Integer id);
}
