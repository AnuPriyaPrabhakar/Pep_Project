//package com.ponsun.pep.searchDetails.service;
//
//import com.ponsun.pep.infrastructure.utils.Response;
//import com.ponsun.pep.searchDetails.request.CreateSearchDetailsRequest;
//
//public interface SearchDetailsWritePlatformService {
//    Response createSearchDetails(CreateSearchDetailsRequest createSearchDetailsRequest);
//}


package com.ponsun.pep.searchDetails.service;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchDetails.request.CreateSearchDetailsRequest;
import com.ponsun.pep.searchDetails.request.UpdateSearchDetailsRequest;

public interface SearchDetailsWritePlatformService {
    Response createSearchDetails(CreateSearchDetailsRequest createSearchDetailsRequest);
    Response updateSearchDetails(Integer id, UpdateSearchDetailsRequest updateSearchDetailsRequest);
}
