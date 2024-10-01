package com.ponsun.pep.reports.QcPendingDt.api;

import com.ponsun.pep.reports.QcPendingDt.data.QcPendingDtData;
import com.ponsun.pep.reports.QcPendingDt.services.QcPendingDtWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/QcPendingDt")
public class QcPendingDtApiResource {
    private  final QcPendingDtWritePlatformService qcPendingDtWritePlatformService;

    @GetMapping
    public List<QcPendingDtData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.qcPendingDtWritePlatformService.fetchAllQcPendingDtData(fromDate , toDate);}
}
