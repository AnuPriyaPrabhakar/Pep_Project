package com.ponsun.pep.master.CompanyMaster.domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyMasterRepository extends JpaRepository<CompanyMaster,Integer> {
    Optional<CompanyMaster> findById(Integer id);
}
