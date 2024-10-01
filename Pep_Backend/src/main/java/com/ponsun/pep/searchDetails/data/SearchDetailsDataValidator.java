package com.ponsun.pep.searchDetails.data;

import com.ponsun.pep.searchDetails.request.CreateSearchDetailsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class SearchDetailsDataValidator {
    public void validateSaveSearchDetails(final CreateSearchDetailsRequest request){
//        if(request.getName() ==  null || request.getName().equals("")){
//            throw new EQAS_PEP_AppicationException("name parameter required");
//        }
    }
}
