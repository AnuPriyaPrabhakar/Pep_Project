package com.ponsun.pep.cutomerEdit.api;


import com.ponsun.pep.cutomerEdit.data.CustomerEditData;
import com.ponsun.pep.cutomerEdit.services.CustomerEditWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/CustomerEdit")

public class CustomerEditApiResource {
    private  final CustomerEditWritePlatformService customerEditWritePlatformService;

    @GetMapping
    public List<CustomerEditData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate ){
        return this.customerEditWritePlatformService.fetchAllCustomerEditData(fromDate , toDate);}
}
