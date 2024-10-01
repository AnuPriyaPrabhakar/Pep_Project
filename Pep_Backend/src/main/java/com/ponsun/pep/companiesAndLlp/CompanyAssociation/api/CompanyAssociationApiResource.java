package com.ponsun.pep.companiesAndLlp.CompanyAssociation.api;

import com.ponsun.pep.companiesAndLlp.CompanyAssociation.domain.CompanyAssociation;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.CreateCompanyAssociationRequest;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.request.UpdateCompanyAssociationRequest;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.services.CompanyAssociationReadPlatformService;
import com.ponsun.pep.companiesAndLlp.CompanyAssociation.services.CompanyAssociationWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/CompanyAssociation")
@Tag(name = "CompanyAssociationApiResource")
public class CompanyAssociationApiResource {
    private final CompanyAssociationWritePlatformService companyAssociationWritePlatformService;
    private final CompanyAssociationReadPlatformService companyAssociationReadPlatformService;
    @PostMapping("/CreateCompanyAssociationRequest")
    public Response saveCompanyAssociation(@RequestBody CreateCompanyAssociationRequest createCompanyAssociationRequest){
        Response response = this.companyAssociationWritePlatformService.createCompanyAssociation(createCompanyAssociationRequest);
        return response;
    }
    @GetMapping
    public List<CompanyAssociation> fetchAll(){ return this.companyAssociationReadPlatformService.fetchAllCompanyAssociation();}
    @GetMapping("/{id}")
    public CompanyAssociation fetchCompanyAssociationById(@PathVariable(name ="id")Integer id){
        return this.companyAssociationReadPlatformService.fetchCompanyAssociationById(id);
    }
    @PutMapping("/{id}")
    public Response updateCompanyAssociation(@PathVariable Integer id, @RequestBody UpdateCompanyAssociationRequest updateCompanyAssociationRequest){
       Response response= this.companyAssociationWritePlatformService.updateCompanyAssociation(id,updateCompanyAssociationRequest);
       return response;
    }
    @PutMapping("/{id}/block")
    public Response blockCompanyAssociation(@PathVariable Integer id){
        Response response = this.companyAssociationWritePlatformService.blockCompanyAssociation(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockCompanyAssociation(@PathVariable Integer id){
        Response response = this.companyAssociationWritePlatformService.unblockCompanyAssociation(id);
        return response;
    }

    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer companyId , @RequestParam Integer euid){
        Response response = this.companyAssociationWritePlatformService.deActive(companyId , euid);
        return response;
    }
}
