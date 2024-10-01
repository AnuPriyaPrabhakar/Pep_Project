package com.ponsun.pep.adminconfiguration.adminconfigmoduledet.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface AdminConfigModuleDetRepository extends JpaRepository<AdminConfigModuleDet, Integer>{
    Optional<AdminConfigModuleDet> findById(Integer id);

//    List<AdminConfigModuleDet> findByPepId(Integer pepId);
}