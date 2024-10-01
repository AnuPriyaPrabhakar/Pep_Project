package com.ponsun.pep.searchLifcycle.ScreeningSearch.services;

import com.ponsun.pep.searchLifcycle.ScreeningSearch.data.ScreeningSearchData;

import java.util.List;

public interface ScreeningSearchWritePlatformService {
    List<ScreeningSearchData> fetchAllScreeningSearch(Integer kycId);
}
