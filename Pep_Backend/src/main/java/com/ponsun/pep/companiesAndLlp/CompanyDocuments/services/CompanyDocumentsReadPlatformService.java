package com.ponsun.pep.companiesAndLlp.CompanyDocuments.services;

import com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain.CompanyDocuments;

import java.util.List;

public interface CompanyDocumentsReadPlatformService {
    List<CompanyDocuments> fetchAllCompanyDocuments();

    CompanyDocuments fetchCompanyDocumentsById(Integer id);
}
