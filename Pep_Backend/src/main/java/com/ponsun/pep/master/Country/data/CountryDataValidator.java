package com.ponsun.pep.master.Country.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.master.Country.request.CreateCountryRequest;
import com.ponsun.pep.master.Country.request.UpdateCountryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountryDataValidator {
    public void validateSaveCountry(final CreateCountryRequest request){
        if (request.getName()== null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");
        }
    }
    public void validateUpdateCountry(final UpdateCountryRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("name parameter required");


        }
    }
}
