package com.ponsun.pep.companyName.api;

import com.ponsun.pep.companyName.data.CompanyNameData;
import com.ponsun.pep.companyName.services.CompanyNameReadPlatFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/CompanyName")
public class CompanyNameApiResource {
    private final CompanyNameReadPlatFormService companyNameReadPlatFormService;

    @GetMapping
    public List<CompanyNameData> fetchAll(@RequestParam String din, @RequestParam String pan){
        return this.companyNameReadPlatFormService.getCompanyName(din,pan);}

}
