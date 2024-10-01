package com.ponsun.pep.reports.ManagerAproveDt.api;


import com.ponsun.pep.reports.ManagerAproveDt.data.ManagerApproveDtData;
import com.ponsun.pep.reports.ManagerAproveDt.services.ManagerApproveDtWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/ManagerApproveDt")
public class ManagerApproveDtApiResource {

    private final ManagerApproveDtWritePlatformService managerApproveDtWritePlatformService;

    @GetMapping
    public List<ManagerApproveDtData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.managerApproveDtWritePlatformService.fetchAllManagerApproveDtData(fromDate , toDate);}
}
