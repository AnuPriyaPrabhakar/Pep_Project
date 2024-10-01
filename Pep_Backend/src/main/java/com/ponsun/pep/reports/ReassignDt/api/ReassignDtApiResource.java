package com.ponsun.pep.reports.ReassignDt.api;


import com.ponsun.pep.reports.ReassignDt.data.ReassignDtData;
import com.ponsun.pep.reports.ReassignDt.services.ReassignDtWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/ReassignDt")
public class ReassignDtApiResource {
    private  final ReassignDtWritePlatformService reassignDtWritePlatformService;

    @GetMapping
    public List<ReassignDtData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.reassignDtWritePlatformService.fetchAllReassignDtData(fromDate , toDate);}
}
