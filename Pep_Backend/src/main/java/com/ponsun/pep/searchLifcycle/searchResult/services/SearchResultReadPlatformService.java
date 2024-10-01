package com.ponsun.pep.searchLifcycle.searchResult.services;

import com.ponsun.pep.searchLifcycle.HitRecord.data.HitRecordData;
import com.ponsun.pep.searchLifcycle.searchResult.data.SearchResultData;
import com.ponsun.pep.searchLifcycle.searchResult.domain.SearchResult;

import java.util.List;

public interface SearchResultReadPlatformService {
    SearchResult fetchSearchById(Integer id);
    List<SearchResult> fetchAllSearch();
    List<SearchResultData> fetchAllSearchDetailData(String fromDate, String toDate);
    List<HitRecordData>fetchAllRecordData(String fromDate, String toDate);
}
