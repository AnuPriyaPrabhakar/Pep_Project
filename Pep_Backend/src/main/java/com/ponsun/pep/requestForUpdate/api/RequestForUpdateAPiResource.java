package com.ponsun.pep.requestForUpdate.api;


import com.ponsun.pep.requestForUpdate.domain.RequestForUpdate;
import com.ponsun.pep.requestForUpdate.request.CreateRequestForUpdateRequest;
import com.ponsun.pep.requestForUpdate.request.UpdateRequestForUpdateRequest;
import com.ponsun.pep.requestForUpdate.services.RequestForUpdateReadPlatformService;
import com.ponsun.pep.requestForUpdate.services.RequestForUpdateWritePlatformService;
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
@RequestMapping("api/v1/RequestForUpdate")
@Tag(name = "RequestForUpdateAPiResource")
public class RequestForUpdateAPiResource {
    private final RequestForUpdateReadPlatformService requestForUpdateReadPlatformService;
    private final RequestForUpdateWritePlatformService requestForUpdateWritePlatformService;


    @PostMapping("/CreateRequestForUpdateRequest")
    public Response saveRequestForUpdateRequest(@RequestBody CreateRequestForUpdateRequest createRequestForUpdateRequest){
        Response response =this.requestForUpdateWritePlatformService.createRequestForUpdateRequest(createRequestForUpdateRequest);
        return response;
    }


    @GetMapping
    public List<RequestForUpdate> fetchAll(){
        return this.requestForUpdateReadPlatformService.fetchAllRequestForUpdate();
    }

    @GetMapping("/{id}")
    public RequestForUpdate fetchRequestForUpdateById(@PathVariable(name = "id") Integer id) {
        return this.requestForUpdateReadPlatformService.fetchRequestForUpdateById(id);
    }

    @PutMapping("/{id}")
    public Response updateRequestForUpdate(@PathVariable Integer id, @RequestBody UpdateRequestForUpdateRequest updateRequestForUpdateRequest){
        log.debug("START updateTaskAssign request body {}",updateRequestForUpdateRequest);
        Response response = this.requestForUpdateWritePlatformService.updateRequestForUpdate(id,updateRequestForUpdateRequest);
        log.debug("START updateTaskAssign response",response);
        return response;
    }

}
