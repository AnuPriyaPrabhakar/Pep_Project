package com.ponsun.pep.companiesAndLlp.CompanyMaster.service;

import com.ponsun.pep.companiesAndLlp.CompanyMaster.request.CreateCompanyRequest;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.request.UpdateCompanyRequest;
import com.ponsun.pep.infrastructure.utils.Response;
import org.springframework.transaction.annotation.Transactional;

public interface CompanyWritePlatformService {
    Response createCompany(CreateCompanyRequest createCompanyRequest);
    Response updateCompany(Integer id, UpdateCompanyRequest updateCompanyRequest);
    Response blockCompany(Integer id);
    Response unblockCompany(Integer id);
    Integer insertCompany(String companyName, CreateCompanyRequest companyRequest);
}
