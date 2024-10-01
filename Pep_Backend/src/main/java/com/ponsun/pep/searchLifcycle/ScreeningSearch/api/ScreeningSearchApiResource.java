package com.ponsun.pep.searchLifcycle.ScreeningSearch.api;


import com.ponsun.pep.searchLifcycle.ScreeningSearch.data.ScreeningSearchData;
import com.ponsun.pep.searchLifcycle.ScreeningSearch.services.ScreeningSearchWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/ScreeningSearch")
public class ScreeningSearchApiResource {
    private final ScreeningSearchWritePlatformService screeningSearchWritePlatformService;

    @GetMapping
    public List<ScreeningSearchData> fetchAll(@RequestParam Integer kycId){
        return this.screeningSearchWritePlatformService.fetchAllScreeningSearch(kycId);
    }
}
