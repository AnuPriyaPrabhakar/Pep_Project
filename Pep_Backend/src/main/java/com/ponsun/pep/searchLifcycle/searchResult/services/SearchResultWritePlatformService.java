package com.ponsun.pep.searchLifcycle.searchResult.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.searchResult.request.CreateSearchResultRequest;
import com.ponsun.pep.searchLifcycle.searchResult.request.UpdateSearchResultRequest;

public interface SearchResultWritePlatformService {
    Response createSearch(CreateSearchResultRequest createSearchRequest);
    Response updateSearch(Integer id, UpdateSearchResultRequest updateSearchRequest);
    Response blockSearch(Integer id);
    Response unblockSearch(Integer id);
}
