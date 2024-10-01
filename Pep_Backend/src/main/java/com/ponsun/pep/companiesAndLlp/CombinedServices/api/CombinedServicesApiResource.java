package com.ponsun.pep.companiesAndLlp.CombinedServices.api;

import com.ponsun.pep.companiesAndLlp.CombinedServices.service.CompanyCompainedReadService;
import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CombinedDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/CompanyGet")
public class CombinedServicesApiResource {
    private final CompanyCompainedReadService companyCompainedReadService;

    @GetMapping
    public List<CombinedDTO> fetchAll(@RequestParam String din){
        return this.companyCompainedReadService.getCompanyActivity(din);}
}
