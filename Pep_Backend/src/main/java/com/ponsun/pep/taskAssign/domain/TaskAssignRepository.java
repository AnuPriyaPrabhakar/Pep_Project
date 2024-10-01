package com.ponsun.pep.taskAssign.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskAssignRepository extends JpaRepository<TaskAssign,Integer> {
    Optional<TaskAssign> findById(Integer id);
}
