package com.ponsun.pep.master.CompanyMaster.api;

import com.ponsun.pep.master.CompanyMaster.request.CreateCompanyMasterRequest;
import com.ponsun.pep.master.CompanyMaster.request.UpdateCompanyMasterRequest;
import com.ponsun.pep.master.CompanyMaster.service.CompanyMasterReadPlatformService;
import com.ponsun.pep.master.CompanyMaster.service.CompanyMasterWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.CompanyMaster.domain.CompanyMaster;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/CompanyMaster")
@Tag(name = "CompanyMasterApiResource")
public class CompanyMasterApiResource {
    private final CompanyMasterWritePlatformService companyMasterWritePlatformService;
    private final CompanyMasterReadPlatformService companyMasterReadPlatformService;
    @PostMapping("/CreateCompanyMasterRequest")
    public Response saveCompanyMaster(@RequestBody CreateCompanyMasterRequest createCompanyMasterRequest) {
        log.debug("START saveCompanyMaster request body {}",createCompanyMasterRequest);
        Response response = this.companyMasterWritePlatformService.createCompanyMaster(createCompanyMasterRequest);
        log.debug("START saveCompanyMaster response",response);
        return response;
    }

    @GetMapping
    public List<CompanyMaster> fetchAll() {
        return this.companyMasterReadPlatformService.fetchAllCompanyMaster();
    }

    @GetMapping("/{id}")
    public CompanyMaster fetchCompanyMasterById(@PathVariable(name = "id") Integer id) {
        return this.companyMasterReadPlatformService.fetchCompanyMasterById(id);
    }
    @PutMapping("/{id}")
    public Response updateCompanyMaster(@PathVariable Integer id, @RequestBody UpdateCompanyMasterRequest updateCompanyMasterRequest) {
        log.debug("START updateCompanyMaster request body {}",updateCompanyMasterRequest);
        Response response = this.companyMasterWritePlatformService.updateCompanyMaster(id, updateCompanyMasterRequest);
        log.debug("START updateCompanyMaster response",response);
        return response;
    }

}
