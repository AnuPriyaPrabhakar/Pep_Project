package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.api;

import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain.AssCompanyContactDet;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.CreateAssCompanyContactDetRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.UpdateAssCompanyContactDetRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.services.AssCompanyContactDetReadPlatformService;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.services.AssCompanyContactDetWritePlatformService;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyContactDTO;
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
@RequestMapping("/api/v1/CompanyContactDet")
@Tag(name = "AssCompanyContactDetApiResource")
public class AssCompanyContactDetApiResource {

    private final AssCompanyContactDetWritePlatformService assCompanyContactDetWritePlatformService;
    private final AssCompanyContactDetReadPlatformService assCompanyContactDetReadPlatformService;


    @PostMapping("/CreateCompanyContactDetRequest")
    public Response saveCompanyContactDet(@RequestBody CreateAssCompanyContactDetRequest createAssCompanyContactDetRequest) {
        Response response = this.assCompanyContactDetWritePlatformService.createCompanyContactDet(createAssCompanyContactDetRequest);
        return response;
    }

    @GetMapping
    public List<AssCompanyContactDet> fetchAll() {
        return this.assCompanyContactDetReadPlatformService.fetchAllCompanyContactDet();
    }

    @GetMapping("/{id}")
    public AssCompanyContactDet fetchCompanyContactDetById(@PathVariable(name = "id") Integer id) {
        return this.assCompanyContactDetReadPlatformService.fetchCompanyContactDetById(id);
    }

    @PutMapping("/{id}")
    public Response updateCompanyContactDet(@PathVariable Integer id, @RequestBody UpdateAssCompanyContactDetRequest updateAssCompanyContactDetRequest) {
        Response response = this.assCompanyContactDetWritePlatformService.updateCompanyContactDet(id, updateAssCompanyContactDetRequest);
        return response;
    }

    @PutMapping("/deactive/{companyId}")
    public Response deactive(@RequestParam Integer companyId, @RequestParam Integer euid) {
        Response response = this.assCompanyContactDetWritePlatformService.deactive(companyId, euid);
        return response;
    }
    @PutMapping("/{id}/block")
    public Response blockCompanyContactDet(@PathVariable Integer id) {
        Response response = this.assCompanyContactDetWritePlatformService.blockCompanyContactDet(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockCompanyContactDet(@PathVariable Integer id) {
        Response response = this.assCompanyContactDetWritePlatformService.unblockCompanyContactDet(id);
        return response;
    }
    @GetMapping("/PepId")
    public List<CompanyContactDTO> fetchAllAssCompanyContactDet(Integer pepId){
        return this.assCompanyContactDetWritePlatformService.fetchAllAssCompanyContactDetData(pepId);
    }
}
