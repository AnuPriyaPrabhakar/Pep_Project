package com.ponsun.pep.master.State.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.Optional;

public interface StateRepository extends JpaRepository<State,Integer>, JpaSpecificationExecutor<State> {
    Optional<State> findById(Integer id);
}
