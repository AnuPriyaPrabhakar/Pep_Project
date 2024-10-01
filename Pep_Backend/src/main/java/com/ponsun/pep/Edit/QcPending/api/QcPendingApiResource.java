
package com.ponsun.pep.Edit.QcPending.api;

import com.ponsun.pep.Edit.QcPending.data.QcPendingData;
import com.ponsun.pep.Edit.QcPending.services.QcPendingWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/QcPending")
public class QcPendingApiResource {
    private  final QcPendingWritePlatformService qcPendingWritePlatformService;

    @GetMapping
    public List<QcPendingData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.qcPendingWritePlatformService.fetchAllQcPendingData(fromDate,toDate);}
}

