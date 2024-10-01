package com.ponsun.pep.companiesAndLlp.CompanyMaster.service;

import com.ponsun.pep.companiesAndLlp.CompanyMaster.domain.Company;

import java.util.List;

public interface CompanyReadPlatformService {
    Company fetchCompanyById(Integer id);

    List<Company> fetchAllCompany();
}
