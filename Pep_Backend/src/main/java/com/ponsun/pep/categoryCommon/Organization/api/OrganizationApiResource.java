package com.ponsun.pep.categoryCommon.Organization.api;

import com.ponsun.pep.categoryCommon.Organization.data.OrganizationData;
import com.ponsun.pep.categoryCommon.Organization.services.OrganizationRedPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/Organization")
public class OrganizationApiResource {

    private  final OrganizationRedPlatformService organizationRedPlatformService;

    @GetMapping
    public List<OrganizationData> fetchAll(String companyName){
        return this.organizationRedPlatformService.fetchAllOrganizationData(companyName);}
}
