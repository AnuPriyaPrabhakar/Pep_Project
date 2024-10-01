package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.data;

import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.CreateCompaniesAddressRequest;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.UpdateCompaniesAddressRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompaniesAddressDataValidator {
    public void validateSaveCompaniesAddressData(final CreateCompaniesAddressRequest request){
        if(request.getCompanyId() == null || request.getCompanyId().equals("")){
            throw new EQAS_PEP_AppicationException("CompanyId parameter required");
        }
    }
    public void validateUpdateCompaniesAddressData(final UpdateCompaniesAddressRequest request){
        if(request.getCompanyId() == null || request.getCompanyId().equals("")){
            throw new EQAS_PEP_AppicationException("CompanyId parameter required");
        }
    }
}
