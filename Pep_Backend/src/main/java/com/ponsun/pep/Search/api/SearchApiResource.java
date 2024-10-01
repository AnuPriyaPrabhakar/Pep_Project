package com.ponsun.pep.Search.api;

import com.ponsun.pep.ReportRecord.data.ReportRecordDtos;

import com.ponsun.pep.Search.data.RecordDTO;
import com.ponsun.pep.Search.data.SearchDTO;
import com.ponsun.pep.Search.data.SearchData;
import com.ponsun.pep.Search.request.CreateSearchRequest;
import com.ponsun.pep.Search.services.SearchReadPlatformService;
import com.ponsun.pep.Search.services.SearchWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchDetails.data.SearchDetailsData;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/Search")
@Tag(name = "SearchApiResource")
public class SearchApiResource {
    private final SearchWritePlatformService searchWritePlatformService;
    private final SearchReadPlatformService searchReadPlatformService;

    @PostMapping("/CreateSearchRequest")
    public Response saveSearch(@RequestBody CreateSearchRequest createSearchRequest) {
        Response response = this.searchWritePlatformService.createSearch(createSearchRequest);
        return response;
    }

    @GetMapping("/fetchAllSearchData")
    public List<SearchData> fetchAllSearchData(@RequestParam String fromDate, @RequestParam String toDate) {
        return this.searchReadPlatformService.fetchAllSearch(fromDate, toDate);
    }

    @GetMapping
    public List<SearchData> fetchAll() {
        return this.searchWritePlatformService.fetchAll();
    }


    @GetMapping("/fetchAllSearchDetailsData")
    public List<SearchDetailsData> fetchAllSearchDetailsData(@RequestParam String fromDate, @RequestParam String toDate) {
        return this.searchReadPlatformService.fetchAllSearchDetails(fromDate, toDate);
    }

    @GetMapping("/Search")
    public List<ReportRecordDtos> fetchAllDetailData(@RequestParam String fromDate, @RequestParam String toDate) {
        return this.searchReadPlatformService.fetchAllDetailData(fromDate, toDate);
    }

//    @GetMapping("/RecordsCount")
//    public List<RecordDTO> getRecords(@RequestBody SearchDTO searchDTO) {
//        return this.searchReadPlatformService.getRecords(searchDTO);
//    }


//    @PostMapping("/RecordsCount")
    @PostMapping("/RecordsCount")
//    public List<RecordDTO> getRecords(@RequestBody SearchDTO searchDTO) {
        public List<RecordDTO> getRecords(@RequestBody SearchDTO searchDTO){
        //System.out.println("search : "+searchDTO);
        List<RecordDTO> recordDTOList = new ArrayList<>();
        //return recordDTOList;
        return this.searchReadPlatformService.getpepRecords(searchDTO);
    }
}
