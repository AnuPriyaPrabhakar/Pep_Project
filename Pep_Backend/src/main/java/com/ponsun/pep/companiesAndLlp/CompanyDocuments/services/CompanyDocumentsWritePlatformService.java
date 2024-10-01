package com.ponsun.pep.companiesAndLlp.CompanyDocuments.services;

import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.CreateCompanyDocumentsRequest;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.UpdateCompanyDocumentsRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface CompanyDocumentsWritePlatformService {
    Response saveCompanyDocuments(CreateCompanyDocumentsRequest createCompanyDocumentsRequest);
    Response updateCompanyDocuments(Integer id, UpdateCompanyDocumentsRequest updateCompanyDocumentsRequest);
    Response deactivateCompanyDocuments(Integer id,UpdateCompanyDocumentsRequest updateCompanyDocumentsRequest);

}
