package com.ponsun.pep.searchLifcycle.hitcaselifecycle.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HitcaseLifecycleRepository extends JpaRepository<HitcaseLifecycle, Integer> {
    Optional<HitcaseLifecycle> findById(Integer id);
}
