package com.ponsun.pep.customerDetails.api;

import com.ponsun.pep.customerDetails.data.CustomerDetailsData;
import com.ponsun.pep.customerDetails.services.CustomerDetailsWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/CustomerDetails")
public class CustomerDetailsApiResource {
    private  final CustomerDetailsWritePlatformService customerDetailsWritePlatformService;

    @GetMapping
    public List<CustomerDetailsData> fetchAll(){
        return this.customerDetailsWritePlatformService.fetchAllCustomerDetailsData();}
}
