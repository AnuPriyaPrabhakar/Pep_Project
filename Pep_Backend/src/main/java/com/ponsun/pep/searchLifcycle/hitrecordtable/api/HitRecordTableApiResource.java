package com.ponsun.pep.searchLifcycle.hitrecordtable.api;
import com.ponsun.pep.searchLifcycle.hitrecordtable.data.HitRecordDataTableData;
import com.ponsun.pep.searchLifcycle.hitrecordtable.services.HitRecordTableWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/hitdatatable")
@CrossOrigin(origins = "http://localhost:3000")
public class HitRecordTableApiResource {
    private final HitRecordTableWritePlatformService hitRecordTableWritePlatformService;
    @GetMapping
    public List<HitRecordDataTableData> fetchAll(@RequestParam String levelId){
        return this.hitRecordTableWritePlatformService.fetchAllHitDataTableData(levelId);
    }
}