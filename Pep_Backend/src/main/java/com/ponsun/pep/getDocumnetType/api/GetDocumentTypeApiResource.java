package com.ponsun.pep.getDocumnetType.api;



import com.ponsun.pep.getDocumnetType.data.GetDocumentTypeData;
import com.ponsun.pep.getDocumnetType.services.GetDocumentTypeReadPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/GetDocumentType")
public class GetDocumentTypeApiResource {

    private  final GetDocumentTypeReadPlatformService getDocumentTypeReadPlatformService;

    @GetMapping
    public List<GetDocumentTypeData> fetchAll(Integer companyId, Integer pathId){
        return this.getDocumentTypeReadPlatformService.getDocumentType(companyId, pathId);
    }
}
