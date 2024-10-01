package com.ponsun.pep.listOfCompany.api;


import com.ponsun.pep.listOfCompany.request.CreateListOfCompanyRequest;
import com.ponsun.pep.listOfCompany.request.UpdateListOfCompanyRequest;
import com.ponsun.pep.listOfCompany.services.ListOfCompanyReadPlatformService;
import com.ponsun.pep.listOfCompany.services.ListOfCompanyWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.listOfCompany.domain.ListOfCompany;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/ListOfCompany")
@Tag(name ="ListOfCompanyApiResource")
public class ListOfCompanyApiResource {
    private final ListOfCompanyWritePlatformService listOfCompanyWritePlatformService;
    private final ListOfCompanyReadPlatformService listOfCompanyReadPlatformService;

    @PostMapping("/CreateListOfCompanyRequest")
    public Response saveListOfCompany(@RequestBody CreateListOfCompanyRequest createListOfCompanyRequest){
       log.debug("START saveListOfCompany request body{}",createListOfCompanyRequest);
       Response response = this.listOfCompanyWritePlatformService.createListOfCompany(createListOfCompanyRequest);
       log.debug("START saveListOfCompany response",response);
       return response;
    }

    @GetMapping("/GetListOfCompany")
    public List<ListOfCompany> fetchAll() { return this.listOfCompanyReadPlatformService.fetchAllListOfCompany();}

    @GetMapping("/{id}")
    public ListOfCompany fetchListOfCompanyById(@PathVariable(name ="id")Integer id){
       return  this.listOfCompanyReadPlatformService.fetchListOfCompanyById(id);
    }

    @PutMapping("/{id}")
    public Response updateListOfCompany(@PathVariable Integer id, @RequestBody UpdateListOfCompanyRequest updateListOfCompanyRequest){
        log.debug("START updateListOfCompany request body {}",updateListOfCompanyRequest);
        Response response = this.listOfCompanyWritePlatformService.updateListOfCompany(id,updateListOfCompanyRequest);
        log.debug("START updateListOfCompany response",response);
        return  response;
    }
}
