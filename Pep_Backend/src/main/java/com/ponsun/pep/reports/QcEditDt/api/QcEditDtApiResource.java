package com.ponsun.pep.reports.QcEditDt.api;



import com.ponsun.pep.reports.QcEditDt.data.QcEditDtData;
import com.ponsun.pep.reports.QcEditDt.services.QcEditDtWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/QcEditDt")
public class QcEditDtApiResource {

    private final QcEditDtWritePlatformService qcEditDtWritePlatformService;

    @GetMapping
    public List<QcEditDtData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.qcEditDtWritePlatformService.fetchAllQcEditDtData(fromDate , toDate);}
}
