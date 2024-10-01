package com.ponsun.pep.cutomerAllData.api;


import com.ponsun.pep.cutomerAllData.data.CustomerAllDataData;
import com.ponsun.pep.cutomerAllData.services.CustomerAllDataWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/CustomerAllData")

public class CustomerAllDataApiResource {
    private  final CustomerAllDataWritePlatformService customerAllDataWritePlatformService;

    @GetMapping
    public List<CustomerAllDataData> fetchAll(){
        return this.customerAllDataWritePlatformService.fetchAllCustomerData();}
}
