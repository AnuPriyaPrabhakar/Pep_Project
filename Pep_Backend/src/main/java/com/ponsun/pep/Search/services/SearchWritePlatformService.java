package com.ponsun.pep.Search.services;

import com.ponsun.pep.Search.data.SearchData;
import com.ponsun.pep.Search.request.CreateSearchRequest;
import com.ponsun.pep.infrastructure.utils.Response;

import java.util.List;

public interface SearchWritePlatformService {
    Response createSearch(CreateSearchRequest createSearchRequest);

    List<SearchData> fetchAll();
}
