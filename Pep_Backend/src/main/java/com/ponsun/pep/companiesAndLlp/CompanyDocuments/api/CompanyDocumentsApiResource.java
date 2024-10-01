package com.ponsun.pep.companiesAndLlp.CompanyDocuments.api;

import com.ponsun.pep.companiesAndLlp.CompanyDocuments.domain.CompanyDocuments;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.CreateCompanyDocumentsRequest;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.request.UpdateCompanyDocumentsRequest;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.services.CompanyDocumentsReadPlatformService;
import com.ponsun.pep.companiesAndLlp.CompanyDocuments.services.CompanyDocumentsWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api/v1/CompanyDocuments")
@Tag(name = "CompanyDocumentsApiResource")
public class CompanyDocumentsApiResource {

    private final CompanyDocumentsReadPlatformService companyDocumentsReadPlatformService;
    private final CompanyDocumentsWritePlatformService companyDocumentsWritePlatformService;

    @PostMapping("/CreateCompanyDocuments")
    public Response saveCompanyDocuments(@RequestBody CreateCompanyDocumentsRequest createCompanyDocumentsRequest){
        Response response = this.companyDocumentsWritePlatformService.saveCompanyDocuments(createCompanyDocumentsRequest);
        return response;
    }

    @GetMapping
    public List<CompanyDocuments> fetchAll(){return this.companyDocumentsReadPlatformService.fetchAllCompanyDocuments();}

    @GetMapping("/{id}")
    public CompanyDocuments fetchCompanyDocumentsById(@PathVariable(name = "id")Integer id){
        return this.companyDocumentsReadPlatformService.fetchCompanyDocumentsById(id);
    }

    @PutMapping("/{id}")
    public Response updateCompanyDocuments(@PathVariable Integer id, @RequestBody UpdateCompanyDocumentsRequest updateCompanyDocumentsRequest){
        Response response = this.companyDocumentsWritePlatformService.updateCompanyDocuments(id, updateCompanyDocumentsRequest);
        return response;
    }

//    @PutMapping("/{id}/block")
//    public Response BlockCompanyDocuments(@PathVariable Integer id, @RequestBody UpdateCompanyDocumentsRequest updateCompanyDocumentsRequest){
//        Response response = this.companyDocumentsWritePlatformService.deactivateCompanyDocuments(id, updateCompanyDocumentsRequest);
//        return response;
//    }
@PutMapping("/DocumentBlock/{id}")
public ResponseEntity<?> blockDocument(@PathVariable Integer id, @RequestBody UpdateCompanyDocumentsRequest updateCompanyDocumentsRequest) {
    this.companyDocumentsWritePlatformService.deactivateCompanyDocuments(id, updateCompanyDocumentsRequest);
    // Return an appropriate response, for example, a success message
    return ResponseEntity.ok("Document blocked successfully");
}

}

