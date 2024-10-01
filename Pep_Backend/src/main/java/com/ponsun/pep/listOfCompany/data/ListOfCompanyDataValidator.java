package com.ponsun.pep.listOfCompany.data;

import com.ponsun.pep.listOfCompany.request.CreateListOfCompanyRequest;
import com.ponsun.pep.listOfCompany.request.UpdateListOfCompanyRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ListOfCompanyDataValidator {
    public void validateSaveListOfCompany(final CreateListOfCompanyRequest request){
        if(request.getType() == null || request.getType().equals("")){
            throw new EQAS_PEP_AppicationException("Type parameter is required");
        }
    }
    public void validateUpdateListOfCompany(final UpdateListOfCompanyRequest request){
        if(request.getType() == null || request.getType().equals("")){
            throw new EQAS_PEP_AppicationException("Type parameter is required");
        }
    }
}
