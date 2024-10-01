package com.ponsun.pep.reports.CreatedAt.api;

import com.ponsun.pep.reports.CreatedAt.data.CreatedAtData;
import com.ponsun.pep.reports.CreatedAt.services.CreatedAtWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/CreatedAt")
public class CreatedAtApiResource {
    private  final CreatedAtWritePlatformService createdAtWritePlatformService;

    @GetMapping
    public List<CreatedAtData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.createdAtWritePlatformService.fetchAllCreatedAtData(fromDate , toDate);}
}
