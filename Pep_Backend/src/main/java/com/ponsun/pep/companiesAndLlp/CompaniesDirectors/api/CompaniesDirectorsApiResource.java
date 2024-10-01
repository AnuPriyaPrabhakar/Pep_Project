package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.api;

import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompaniesDirectorsDTO;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain.CompaniesDirectors;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.CreatCompaniesDirectorsRequest;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.UpdateCompaniesDirectorsRequest;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.services.CompaniesDirectorsReadPlatformService;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.services.CompaniesDirectorsWritePlatformService;
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
@RequestMapping("/api/v1/CompaniesDirectors")
@Tag(name = "CompaniesDirectorsApiResource")
public class CompaniesDirectorsApiResource {
    private final CompaniesDirectorsWritePlatformService companiesDirectorsWritePlatformService;
    private final CompaniesDirectorsReadPlatformService companiesDirectorsReadPlatformService;
    @PostMapping("/CreateCompaniesDirectorsRequest")
    public Response saveCompaniesDirectors(@RequestBody CreatCompaniesDirectorsRequest creatCompaniesAddressRequest){
        Response response = this.companiesDirectorsWritePlatformService.createCompaniesDirectors(creatCompaniesAddressRequest);
        return response;
    }
    @GetMapping
    public List<CompaniesDirectors> fetchAll(){ return this.companiesDirectorsReadPlatformService.fetchAllCompaniesAddress();}

    @GetMapping("/{id}")
    public CompaniesDirectors fetchCompaniesDirectorsById(@PathVariable(name = "id")Integer id){
        return this.companiesDirectorsReadPlatformService.fetchCompaniesDirectorsById(id);
    }

    @PutMapping("/deactive/{companyId}")
    public Response deactive(@PathVariable Integer companyId, Integer euid) {
        Response response = this.companiesDirectorsWritePlatformService.deActive(companyId, euid);
        return response;
    }

    @PutMapping("/{id}")
    public Response updateCompaniesDirectors(@PathVariable Integer id, @RequestBody UpdateCompaniesDirectorsRequest updateCompaniesDirectorsRequest){
        Response response = this.companiesDirectorsWritePlatformService.updateCompaniesDirectors(id,updateCompaniesDirectorsRequest);
        return  response;
    }
    @PutMapping("/{id}/block")
    public Response blockCompaniesDirectors(@PathVariable Integer id){
        Response response = this.companiesDirectorsWritePlatformService.blockCompaniesDirectors(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockCompaniesDirectors(@PathVariable Integer id){
        Response response = this.companiesDirectorsWritePlatformService.unblockCompaniesDirectors(id);
        return  response;
    }
    @GetMapping("/companyId")
    public List<CompaniesDirectorsDTO> fetchAllCompaniesDirectorsData(Integer companyId){
        return this.companiesDirectorsWritePlatformService.fetchAllCompaniesDirectorsData(companyId);
    }
}

