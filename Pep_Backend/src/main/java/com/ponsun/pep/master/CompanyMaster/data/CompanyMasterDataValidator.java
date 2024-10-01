package com.ponsun.pep.master.CompanyMaster.data;

import com.ponsun.pep.master.CompanyMaster.request.CreateCompanyMasterRequest;
import com.ponsun.pep.master.CompanyMaster.request.UpdateCompanyMasterRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyMasterDataValidator {
    public void validateSaveCompany(final CreateCompanyMasterRequest request){
        if (request.getName()== null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
    public void validateUpdateCompany(final UpdateCompanyMasterRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
}
