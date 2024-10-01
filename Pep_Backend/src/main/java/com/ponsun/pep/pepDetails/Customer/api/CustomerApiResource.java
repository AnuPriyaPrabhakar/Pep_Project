package com.ponsun.pep.pepDetails.Customer.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.Country.domain.Country;
import com.ponsun.pep.master.Country.request.CreateCountryRequest;
import com.ponsun.pep.master.Country.request.UpdateCountryRequest;
import com.ponsun.pep.master.Country.services.CountryReadPlatformService;
import com.ponsun.pep.pepDetails.Customer.domain.Customer;
import com.ponsun.pep.pepDetails.Customer.request.CreateCustomerRequest;
import com.ponsun.pep.pepDetails.Customer.request.UpdateCustomerRequest;
import com.ponsun.pep.pepDetails.Customer.services.CustomerReadPlatformService;
import com.ponsun.pep.pepDetails.Customer.services.CustomerWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/Customer")
@Tag(name = "CustomerApiResource")
public class CustomerApiResource {

    private final CustomerWritePlatformService customerWritePlatformService;
    private final CustomerReadPlatformService customerReadPlatformService;

    @PostMapping("/CreateCustomerRequest")
    public Response saveCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        Response response = this.customerWritePlatformService.createCustomer(createCustomerRequest);
        return response;
    }

    @PutMapping("/updateCustomer")
    public Response updateCustomer(Integer id,@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        Response response = this.customerWritePlatformService.updateCustomer(id, updateCustomerRequest);
           return response;
    }

    @GetMapping
    public List<Customer> fetchAll() {
        return this.customerReadPlatformService.fetchAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer fetchCustomerById(@PathVariable(name = "id") Integer id) {
        return this.customerReadPlatformService.fetchCustomerById(id);
    }
//    @PutMapping("/{id}")
//    public Response updateCustomer(@PathVariable Integer id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
//        Response response = this.customerWritePlatformService.updateCustomer(id, updateCustomerRequest);
//        return response;
//    }

    @DeleteMapping("/{id}")
    public Response deleteCustomer(@PathVariable(name = "id") Integer id) {
        Response response = this.customerWritePlatformService.deleteCustomer(id);
        return response;
    }


    @PutMapping("/checked")
    public Response checked(@RequestParam String checked) {
        Response response = this.customerWritePlatformService.checked(checked);
        return response;
    }

}
