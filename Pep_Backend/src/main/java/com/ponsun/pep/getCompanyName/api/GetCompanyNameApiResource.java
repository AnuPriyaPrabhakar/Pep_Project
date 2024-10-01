package com.ponsun.pep.getCompanyName.api;

import com.ponsun.pep.getCompanyName.services.GetCompanyNameWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/GetCompanyName")
public class GetCompanyNameApiResource {

    private  final GetCompanyNameWritePlatformService getCompanyNameWritePlatformService;

    @GetMapping
//    public List<GetCompanyNameData> fetchAll(@RequestParam Integer pepId , @RequestParam String companyName){
//        return this.getCompanyNameWritePlatformService.fetchAllGetCompanyNameData(companyName);}
    public Integer getCompanyId(String companyName){
        return this.getCompanyNameWritePlatformService.getCompanyId(companyName);
    }
}
