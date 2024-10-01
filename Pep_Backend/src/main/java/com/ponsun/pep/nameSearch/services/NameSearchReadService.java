package com.ponsun.pep.nameSearch.services;


import com.ponsun.pep.nameSearch.data.NameSearchData;

import java.util.List;

public interface NameSearchReadService {

    List<NameSearchData> fetchAllNameSearch(Integer kycId);
}
