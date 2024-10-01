package com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.api;



import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.domain.DocumentTypeMaster;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.request.CreateDocumentTypeMasterRequest;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.services.DocumentTypeMasterReadPlatformService;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.services.DocumentTypeMasterWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/DocumentTypeMaster")
@Tag(name = "DocumentTypeMasterApiResource")
public class DocumentTypeMasterApiResource {



    private final DocumentTypeMasterReadPlatformService documentTypeMasterReadPlatformService;
    private final DocumentTypeMasterWritePlatformService documentTypeMasterWritePlatformService;


    @PostMapping("/CreateDocumentTypeMaster")
    public Response saveDocumentTypeMaster(@RequestBody CreateDocumentTypeMasterRequest createDocumentTypeMasterRequest){
        Response response = this.documentTypeMasterWritePlatformService.createDocumentTypeMaster(createDocumentTypeMasterRequest);
        return response;
    }

    @GetMapping
    public List<DocumentTypeMaster> fetchAll(){return this.documentTypeMasterReadPlatformService.fetchAllDocumentTypeMaster();}

    @GetMapping("/{id}")
    public DocumentTypeMaster fetchDirectorsMasterById(@PathVariable(name = "id")Integer id){
        return this.documentTypeMasterReadPlatformService.fetchDocumentTypeMasterById(id);

    }
}
