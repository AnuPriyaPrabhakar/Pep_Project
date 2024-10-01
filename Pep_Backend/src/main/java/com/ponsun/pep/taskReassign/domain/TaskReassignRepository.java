package com.ponsun.pep.taskReassign.domain;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskReassignRepository  extends JpaRepository<TaskReassign,Integer> {
    TaskReassign  findByPepId(Integer PepId);
}
