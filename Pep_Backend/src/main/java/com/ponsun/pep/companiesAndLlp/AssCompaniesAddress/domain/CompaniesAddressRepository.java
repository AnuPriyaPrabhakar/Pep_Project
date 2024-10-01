package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain;

import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyAddressDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompaniesAddressRepository extends JpaRepository<CompaniesAddress,Integer> {
    Optional<CompaniesAddress> findById(Integer id);
    List<CompaniesAddress> findByCompanyId(Integer companyId);
}
