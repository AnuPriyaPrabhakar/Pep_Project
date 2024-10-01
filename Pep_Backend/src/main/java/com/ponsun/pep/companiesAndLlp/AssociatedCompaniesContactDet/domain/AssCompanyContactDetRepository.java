package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain;


import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyContactDTO;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AssCompanyContactDetRepository extends JpaRepository<AssCompanyContactDet, Integer> {
    Optional<AssCompanyContactDet> findById(Integer id);
    List<AssCompanyContactDet> findByCompanyId(@Param("companyId") Integer companyId);
}