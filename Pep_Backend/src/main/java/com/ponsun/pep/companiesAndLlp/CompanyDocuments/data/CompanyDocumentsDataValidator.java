package com.ponsun.pep.companiesAndLlp.CompanyDocuments.data;


import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.CreateCompanyDocumentsRequest;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.UpdateCompanyDocumentsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class
CompanyDocumentsDataValidator {
    public void validateSaveCompanyDocuments(final CreateCompanyDocumentsRequest request) {
        if (request.getCompanyId() == null || request.getCompanyId().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
    public void validateUpdateCompanyDocuments(final UpdateCompanyDocumentsRequest request) {
        if (request.getCompanyId() == null || request.getCompanyId().equals("")) {
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
}
