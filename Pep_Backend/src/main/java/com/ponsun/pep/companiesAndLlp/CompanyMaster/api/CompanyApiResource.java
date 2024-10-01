package com.ponsun.pep.companiesAndLlp.CompanyMaster.api;

import com.ponsun.pep.companiesAndLlp.CompanyMaster.request.CreateCompanyRequest;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.request.UpdateCompanyRequest;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.service.CompanyReadPlatformService;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.service.CompanyWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.domain.Company;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/Company")
@Tag(name = "CompanyApiResource")
public class CompanyApiResource {
    private final CompanyWritePlatformService companyWritePlatformService;
    private final CompanyReadPlatformService companyReadPlatformService;

    @PostMapping("/CreateCompanyRequest")
    public Response saveCompany(@RequestBody CreateCompanyRequest createCompanyRequest) {
        log.debug("START saveCompany request body {}",createCompanyRequest);
        Response response = this.companyWritePlatformService.createCompany(createCompanyRequest);
        log.debug("START saveCompany response",response);
        return response;
    }

    @GetMapping
    public List<Company> fetchAll() {
        return this.companyReadPlatformService.fetchAllCompany();
    }

    @GetMapping("/{id}")
    public Company fetchCompanyById(@PathVariable(name = "id") Integer id) {
        return this.companyReadPlatformService.fetchCompanyById(id);
    }
    @PutMapping("/{id}")
    public Response updateCompany(@PathVariable Integer id, @RequestBody UpdateCompanyRequest updateCompanyRequest) {
        log.debug("START updateCompany request body {}",updateCompanyRequest);
        Response response = this.companyWritePlatformService.updateCompany(id, updateCompanyRequest);
        log.debug("START updateCompany response",response);
        return response;
    }

    @PutMapping("/{id}/block")
    public Response blockCompany(@PathVariable Integer id){
        Response response = this.companyWritePlatformService.blockCompany(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockCompany(@PathVariable Integer id){
        Response response = this.companyWritePlatformService.unblockCompany(id);
        return response;
    }

}
