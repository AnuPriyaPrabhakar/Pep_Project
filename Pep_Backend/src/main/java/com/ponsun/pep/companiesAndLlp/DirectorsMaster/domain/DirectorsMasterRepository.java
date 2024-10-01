package com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectorsMasterRepository extends JpaRepository<DirectorsMaster,Integer> {

    Optional<DirectorsMaster> findById(Integer id);
}
