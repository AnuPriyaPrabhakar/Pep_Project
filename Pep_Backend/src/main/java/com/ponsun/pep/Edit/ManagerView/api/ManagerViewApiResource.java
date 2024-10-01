package com.ponsun.pep.Edit.ManagerView.api;
import com.ponsun.pep.Edit.ManagerView.Services.ManagerViewReadPlatformService;
import com.ponsun.pep.Edit.ManagerView.data.ManagerViewData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/ManagerView")
public class ManagerViewApiResource {
    private  final ManagerViewReadPlatformService managerViewReadPlatformService;

    @GetMapping
    public List<ManagerViewData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.managerViewReadPlatformService.fetchAllManagerViewData(fromDate,toDate);}
}
