package com.ponsun.pep.searchLifcycle.searchResult.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.searchResult.domain.SearchResult;
import com.ponsun.pep.searchLifcycle.searchResult.request.CreateSearchResultRequest;
import com.ponsun.pep.searchLifcycle.searchResult.request.UpdateSearchResultRequest;
import com.ponsun.pep.searchLifcycle.searchResult.services.SearchResultReadPlatformService;
import com.ponsun.pep.searchLifcycle.searchResult.services.SearchResultWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/SearchResult")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name="SearchResultApiResource")
public class SearchResultApiResource {
    private final SearchResultWritePlatformService searchResultWritePlatformService;
    private final SearchResultReadPlatformService searchResultReadPlatformService;

    @PostMapping("/createSearchResult")
    public Response saveSearch(@RequestBody CreateSearchResultRequest createSearchRequest){
        Response response = this.searchResultWritePlatformService.createSearch(createSearchRequest);
        return response;
    }
    @GetMapping
    public List<SearchResult> fetchAll() {
        return this.searchResultReadPlatformService.fetchAllSearch();
    }

    @GetMapping("/{id}")
    public SearchResult fetchSearchById(@PathVariable(name = "id") Integer id) {
        return this.searchResultReadPlatformService.fetchSearchById(id);
    }

    @PutMapping("/{id}")
    public Response updateSearch(@PathVariable Integer id, @RequestBody UpdateSearchResultRequest updateSearchRequest) {
        Response response = this.searchResultWritePlatformService.updateSearch(id, updateSearchRequest);
        return response;
    }

    @PutMapping("/{id}/block")
    public Response blockSearch(@PathVariable Integer id) {
        Response response = this.searchResultWritePlatformService.blockSearch(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockSearch(@PathVariable Integer id) {
        Response response = this.searchResultWritePlatformService.unblockSearch(id);
        return response;
    }
}

