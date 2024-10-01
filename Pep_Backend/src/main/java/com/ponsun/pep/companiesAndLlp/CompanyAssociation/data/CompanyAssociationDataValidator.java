package com.ponsun.pep.companiesAndLlp.CompanyAssociation.data;

import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.CreateCompanyAssociationRequest;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.UpdateCompanyAssociationRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CompanyAssociationDataValidator {
    public void validateSaveCompanyAssociationData(final CreateCompanyAssociationRequest request){
        if(request.getCompanyId() == null || request.getCompanyId().equals(" ")){
            throw new EQAS_PEP_AppicationException("CompanyId parameter required");
        }
    }
    public void validateUpdateCompanyAssociationData(final UpdateCompanyAssociationRequest request){
        if(request.getCompanyId() == null || request.getCompanyId().equals("")){
            throw new EQAS_PEP_AppicationException("CompanyId parameter required");
        }
    }
}
