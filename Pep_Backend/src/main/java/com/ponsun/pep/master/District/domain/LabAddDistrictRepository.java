package com.ponsun.pep.master.District.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LabAddDistrictRepository extends JpaRepository<LabAddDistrict, Long>, JpaSpecificationExecutor<LabAddDistrict> {

}