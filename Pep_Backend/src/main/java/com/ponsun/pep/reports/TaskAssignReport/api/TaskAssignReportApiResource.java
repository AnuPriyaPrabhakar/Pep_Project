package com.ponsun.pep.reports.TaskAssignReport.api;

import com.ponsun.pep.reports.TaskAssignReport.data.TaskAssignReportData;
import com.ponsun.pep.reports.TaskAssignReport.services.TaskAssignReportWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/TaskAssignReport")
public class TaskAssignReportApiResource {
    private final TaskAssignReportWritePlatformService taskAssignReportWritePlatformService;

    @GetMapping
    public List<TaskAssignReportData> fetchAll(@RequestParam String fromDate,@RequestParam String toDate){
        return this.taskAssignReportWritePlatformService.fetchAllTaskAssignReportData(fromDate,toDate);}
    }

