package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.api;

import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain.CompaniesAddress;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.CreateCompaniesAddressRequest;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.UpdateCompaniesAddressRequest;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.services.CompaniesAddressReadPlatformService;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.services.CompaniesAddressWritePlatformService;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyAddressDTO;
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
@RequestMapping("/api/v1/CompaniesAddress")
@Tag(name = "CompaniesAddressApiResource")
public class CompaniesAddressApiResource {
    private final CompaniesAddressWritePlatformService companiesAddressWritePlatformService;
    private final CompaniesAddressReadPlatformService companiesAddressReadPlatformService;
    @PostMapping("/CreateCompaniesAddressRequest")
    public Response saveCompaniesAddress(@RequestBody CreateCompaniesAddressRequest createCompaniesAddressRequest){
        Response response = this.companiesAddressWritePlatformService.createCompaniesAddress(createCompaniesAddressRequest);
        return response;
    }
    @GetMapping
    public List<CompaniesAddress> fetchAll(){ return this.companiesAddressReadPlatformService.fetchAllCompaniesAddress();}

    @GetMapping("/{id}")
    public CompaniesAddress fetchCompaniesAddressById(@PathVariable(name = "id")Integer id){
        return this.companiesAddressReadPlatformService.fetchCompaniesAddressById(id);
    }


    @PutMapping("/deactive/{companyId}")
    public Response deactive(@RequestParam Integer companyId,@RequestParam Integer euid) {
        Response response = this.companiesAddressWritePlatformService.deActive(companyId, euid);
        return response;
    }

    @PutMapping("/{id}")
    public Response updateCompaniesAddress(@PathVariable Integer id, @RequestBody UpdateCompaniesAddressRequest updateCompaniesAddressRequest){
        Response response = this.companiesAddressWritePlatformService.updateCompaniesAddress(id,updateCompaniesAddressRequest);
        return  response;
    }
    @PutMapping("/{id}/block")
    public Response blockCompaniesAddress(@PathVariable Integer id){
        Response response = this.companiesAddressWritePlatformService.blockCompaniesAddress(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockCompaniesAddress(@PathVariable Integer id){
       Response response = this.companiesAddressWritePlatformService.unblockCompaniesAddress(id);
       return  response;
    }
    @GetMapping("/pepId")
    public List<CompanyAddressDTO> fetchAllCompaniesAddressData(Integer pepId){
        return this.companiesAddressWritePlatformService.fetchAllCompaniesAddressData(pepId);
    }
}
