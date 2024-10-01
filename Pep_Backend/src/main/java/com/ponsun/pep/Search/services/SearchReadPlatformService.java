package com.ponsun.pep.Search.services;

import com.ponsun.pep.ReportRecord.data.ReportRecordDtos;
import com.ponsun.pep.Search.data.RecordDTO;
import com.ponsun.pep.Search.data.SearchDTO;
import com.ponsun.pep.Search.data.SearchData;
import com.ponsun.pep.Search.domain.Search;
import com.ponsun.pep.searchDetails.data.SearchDetailsData;

import java.util.List;

public interface SearchReadPlatformService {

    List<Search> fetchAllSearch();
    List<SearchData> fetchAllSearch(String fromDate, String toDate);
    List<SearchDetailsData> fetchAllSearchDetails(String fromDate,String toDate);
    List<ReportRecordDtos>fetchAllDetailData(String fromDate, String toDate);
    List<RecordDTO> getpepRecords(SearchDTO searchDto);

}
