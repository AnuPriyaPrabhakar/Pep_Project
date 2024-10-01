package com.ponsun.pep.searchLifcycle.screeningRecord.api;


import com.ponsun.pep.searchLifcycle.screeningRecord.data.ScreeningRecordData;
import com.ponsun.pep.searchLifcycle.screeningRecord.services.ScreeningRecordWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/ScreeningRecord")
public class ScreeningRecordApiResource {
    private final ScreeningRecordWritePlatformService screeningRecordWritePlatformService;
    @GetMapping
    public List<ScreeningRecordData> fetchAll(@RequestParam Integer id){
        return this.screeningRecordWritePlatformService.fetchAllScreeningRecord(id);
    }
}
