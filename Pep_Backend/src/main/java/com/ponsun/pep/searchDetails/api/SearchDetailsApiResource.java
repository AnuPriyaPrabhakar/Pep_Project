//package com.ponsun.pep.searchDetails.api;
//
//import com.ponsun.pep.infrastructure.utils.Response;
//import com.ponsun.pep.searchDetails.request.CreateSearchDetailsRequest;
//import com.ponsun.pep.searchDetails.service.SearchDetailsWritePlatformService;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@Slf4j
//@RequiredArgsConstructor
//@RequestMapping("api/v1/SearchDetails")
//@Tag(name="SearchDetailsApiResource")
//public class SearchDetailsApiResource {
//    private final SearchDetailsWritePlatformService searchDetailsWritePlatformService;
//
//    @PostMapping("/CreateSearchDetailsRequest")
//    public Response saveSearchDetailsRequest(@RequestBody CreateSearchDetailsRequest createSearchDetailsRequest){
//        Response response = this.searchDetailsWritePlatformService.createSearchDetails(createSearchDetailsRequest);
//        return response;
//    }
//}

package com.ponsun.pep.searchDetails.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchDetails.domain.SearchDetails;
import com.ponsun.pep.searchDetails.request.CreateSearchDetailsRequest;
import com.ponsun.pep.searchDetails.request.UpdateSearchDetailsRequest;
import com.ponsun.pep.searchDetails.service.SearchDetailsReadPlatformService;
import com.ponsun.pep.searchDetails.service.SearchDetailsWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/searchDetails")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name="SearchDetailsApiResource")
public class SearchDetailsApiResource
{
    private final SearchDetailsWritePlatformService searchDetailsWritePlatformService;
    private final SearchDetailsReadPlatformService searchDetailsReadPlatformService;

    @PostMapping("/CreateSearchDetails")
    public Response saveSearchDetails(@RequestBody CreateSearchDetailsRequest createSearchDetailsRequest){
        Response response = this.searchDetailsWritePlatformService.createSearchDetails(createSearchDetailsRequest);
        return response;
    }
    @GetMapping
    public List<SearchDetails> fetchAll() {return this.searchDetailsReadPlatformService.fetchAllSearchDetails();}

    @GetMapping("/{id}")
    public SearchDetails fetchSearchDetailsById(@PathVariable(name="id")Integer id){
        return this.searchDetailsReadPlatformService.fetchSearchDetailsById(id);
    }

    @PutMapping("/{id}")
    public Response updateSearchDetails(@PathVariable Integer id, @RequestBody UpdateSearchDetailsRequest updateSearchDetailsRequest){
        Response response = this.searchDetailsWritePlatformService.updateSearchDetails(id,updateSearchDetailsRequest);
        return response;
    }
}

