package com.ponsun.pep.reports.PublishedDt.api;

import com.ponsun.pep.reports.PublishedDt.data.PublishedDtData;
import com.ponsun.pep.reports.PublishedDt.services.PublishedDtWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/PublishedDt")

public class PublishedDtApiResource {
    private final PublishedDtWritePlatformService publishedDtWritePlatformService;

    @GetMapping
    public List<PublishedDtData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.publishedDtWritePlatformService.fetchAllPublishedDtData(fromDate , toDate);}
}