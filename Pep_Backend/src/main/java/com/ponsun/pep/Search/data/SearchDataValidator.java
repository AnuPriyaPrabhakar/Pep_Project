package com.ponsun.pep.Search.data;

import com.ponsun.pep.Search.request.CreateSearchRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SearchDataValidator {
    public void validateSaveSearch(final CreateSearchRequest request) {
//        if (request.getName() == null || request.getName().equals("")) {
//            throw new EQAS_PEP_AppicationException("name parameter required");
//        }
    }
}
