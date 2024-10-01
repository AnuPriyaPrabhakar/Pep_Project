package com.ponsun.pep.master.District.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.master.District.request.CreateDistrictRequest;
import com.ponsun.pep.master.District.request.UpdateDistrictRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DistrictDataValidator {
    public void validateSaveDistrict(final CreateDistrictRequest request) {
        if (request.getCityName() == null || request.getCityName().equals("")) {
            throw new EQAS_PEP_AppicationException("CityName parameter required");
        }
    }
    public void validateUpdateDistrict(final UpdateDistrictRequest request) {
        if (request.getCityName() == null || request.getCityName().equals("")) {
            throw new EQAS_PEP_AppicationException("CityName parameter required");
        }
    }
}