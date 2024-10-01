package com.ponsun.pep.Edit.ViewApprove.api;


import com.ponsun.pep.Edit.QcView.data.QcViewData;
import com.ponsun.pep.Edit.QcView.services.QcViewWritePlatformService;
import com.ponsun.pep.Edit.ViewApprove.data.ViewApproveData;
import com.ponsun.pep.Edit.ViewApprove.services.ViewApproveReadPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/ViewApprove")
public class ViewApproveApiResource {
    private  final ViewApproveReadPlatformService viewApproveReadPlatformService;

    @GetMapping
    public List<ViewApproveData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.viewApproveReadPlatformService.fetchAllViewApproveData(fromDate,toDate);}

}
