

package com.ponsun.pep.searchDetails.service;

import com.ponsun.pep.searchDetails.data.SearchDetailsData;
import com.ponsun.pep.searchDetails.domain.SearchDetails;

import java.util.List;

public interface SearchDetailsReadPlatformService {
    SearchDetails fetchSearchDetailsById(Integer id);
    List<SearchDetails> fetchAllSearchDetails();
    List<SearchDetailsData> fetchAllDetailsDataById(Integer searchId);
}
