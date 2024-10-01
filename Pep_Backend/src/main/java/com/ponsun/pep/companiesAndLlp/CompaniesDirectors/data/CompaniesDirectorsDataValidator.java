package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.data;


import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.CreatCompaniesDirectorsRequest;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.UpdateCompaniesDirectorsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompaniesDirectorsDataValidator {

    public void validateSaveCompaniesDirectorsData(final CreatCompaniesDirectorsRequest request){
        if(request.getCompanyId() == null || request.getCompanyId().equals("")){
            throw new EQAS_PEP_AppicationException("CompanyId parameter required");
        }
    }
    public void validateUpdateCompaniesDirectorsData(final UpdateCompaniesDirectorsRequest request){
        if(request.getCompanyId() == null || request.getCompanyId().equals("")){
            throw new EQAS_PEP_AppicationException("CompanyId parameter required");
        }
    }

}
