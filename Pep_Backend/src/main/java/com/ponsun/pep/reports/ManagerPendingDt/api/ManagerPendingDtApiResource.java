package com.ponsun.pep.reports.ManagerPendingDt.api;

import com.ponsun.pep.reports.ManagerPendingDt.data.ManagerPendingDtData;
import com.ponsun.pep.reports.ManagerPendingDt.services.ManagerPendingDtWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/ManagerPendingDt")
public class ManagerPendingDtApiResource {


    private final ManagerPendingDtWritePlatformService managerPendingDtWritePlatformService;

    @GetMapping
    public List<ManagerPendingDtData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.managerPendingDtWritePlatformService.fetchAllManagerPendingDtData(fromDate , toDate);}
}

