package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.data;

import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.CreateAssCompanyContactDetRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.UpdateAssCompanyContactDetRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AssCompanyContactDetDataValidator {

    public void validateSaveCompanyContactDetData (final CreateAssCompanyContactDetRequest request) {
        if (request.getEmailID() == null || request.getEmailID().equals("")) {
            throw new EQAS_PEP_AppicationException("EmailId parameter required");
        }
    }

    public void validateUpdateCompanyContactDetData (final UpdateAssCompanyContactDetRequest request) {
        if (request.getEmailID() == null || request.getEmailID().equals("")) {
            throw new EQAS_PEP_AppicationException("EmailId parameter required");
        }
    }
}