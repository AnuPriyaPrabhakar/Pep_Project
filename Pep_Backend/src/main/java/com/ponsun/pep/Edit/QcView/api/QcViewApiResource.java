package com.ponsun.pep.Edit.QcView.api;

import com.ponsun.pep.Edit.QcView.data.QcViewData;
import com.ponsun.pep.Edit.QcView.services.QcViewWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/QcView")
public class QcViewApiResource {
    private  final QcViewWritePlatformService qcViewWritePlatformService;

    @GetMapping
    public List<QcViewData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.qcViewWritePlatformService.fetchAllQcViewData(fromDate,toDate);}
}
