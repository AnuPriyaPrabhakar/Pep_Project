package com.ponsun.pep.Edit.ManagerPending.api;

import com.ponsun.pep.Edit.ManagerPending.data.QcManagerPendingData;
import com.ponsun.pep.Edit.ManagerPending.services.QcManagerPendingWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/QcManagerPending")
public class QcManagerPendingApiResource {
    private  final QcManagerPendingWritePlatformService qcManagerPendingWritePlatformService;

    @GetMapping
    public List<QcManagerPendingData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.qcManagerPendingWritePlatformService.fetchAllQcManagerPendingData(fromDate,toDate);}
}
