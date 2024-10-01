package com.ponsun.pep.requestForUpdate.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RequestForUpdateRepository extends JpaRepository<RequestForUpdate,Integer> {

    Optional<RequestForUpdate> findById(Integer id);
}
