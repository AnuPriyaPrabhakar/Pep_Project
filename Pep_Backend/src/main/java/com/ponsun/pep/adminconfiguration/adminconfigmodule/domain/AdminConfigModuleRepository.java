package com.ponsun.pep.adminconfiguration.adminconfigmodule.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminConfigModuleRepository extends JpaRepository<AdminConfigModule, Integer> {
    Optional<AdminConfigModule> findById(Integer id);


}