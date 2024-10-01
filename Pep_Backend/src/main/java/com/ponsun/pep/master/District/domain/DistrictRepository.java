package com.ponsun.pep.master.District.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Integer>, JpaSpecificationExecutor<District> {

    Optional<District> findById(Integer id);

}