package com.ponsun.pep.categoryCommon.All.api;

import com.ponsun.pep.categoryCommon.All.data.AllData;
import com.ponsun.pep.categoryCommon.All.services.AllWritePlatFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/All")
public class AllApiResource {
    private  final AllWritePlatFormService allWritePlatFormService;

    @GetMapping
    public List<AllData> fetchAll(String pepName){
        return this.allWritePlatFormService.fetchAllAllData(pepName);}
}
