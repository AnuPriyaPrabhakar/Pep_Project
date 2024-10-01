package com.ponsun.pep.companiesAndLlp.CompanyMaster.data;

import com.ponsun.pep.companiesAndLlp.CompanyMaster.request.CreateCompanyRequest;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.request.UpdateCompanyRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyDataValitor {
    public void validateSaveCompany(final CreateCompanyRequest request){
        if (request.getName()== null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
    public void validateUpdateCompany(final UpdateCompanyRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");


        }
    }
}
