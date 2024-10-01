package com.ponsun.pep.reports.QcViewDt.api;


import com.ponsun.pep.reports.QcViewDt.data.QcViewDtData;
import com.ponsun.pep.reports.QcViewDt.services.QcViewDtWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/QcViewDt")
public class QcViewDtApiResource {
    private  final QcViewDtWritePlatformService qcViewDtWritePlatformService;

    @GetMapping
    public List<QcViewDtData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.qcViewDtWritePlatformService.fetchAllQcViewDtData(fromDate , toDate);}
}
