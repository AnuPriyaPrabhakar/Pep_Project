package com.ponsun.pep.Edit.ManagerViewPending.api;



import com.ponsun.pep.Edit.ManagerViewPending.data.ManagerViewPendingData;
import com.ponsun.pep.Edit.ManagerViewPending.services.ManagerViewPendingReadPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/ManagerViewPending")
public class ManagerViewPendingApiResource {
    private  final ManagerViewPendingReadPlatformService managerViewPendingReadPlatformService;

    @GetMapping
    public List<ManagerViewPendingData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.managerViewPendingReadPlatformService.fetchAllManagerViewPendingData(fromDate,toDate);}

}
