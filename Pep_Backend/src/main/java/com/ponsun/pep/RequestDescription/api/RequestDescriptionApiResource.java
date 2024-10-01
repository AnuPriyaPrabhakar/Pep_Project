package com.ponsun.pep.RequestDescription.api;

import com.ponsun.pep.RequestDescription.domain.RequestDescription;
import com.ponsun.pep.RequestDescription.request.CreateRequestDescriptionRequest;
import com.ponsun.pep.RequestDescription.request.UpdateRequestDescriptionRequest;
import com.ponsun.pep.RequestDescription.services.RequestDescriptionReadPlatformService;
import com.ponsun.pep.RequestDescription.services.RequestDescriptionWritePlatformService;
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
@RequestMapping("/api/v1/RequestDescription")
@Tag(name = "RequestDescriptionApiResource")
public class RequestDescriptionApiResource {
    private final RequestDescriptionWritePlatformService requestDescriptionWritePlatformService;
    private final RequestDescriptionReadPlatformService requestDescriptionReadPlatformService;

    @PostMapping("/CreateRequestDescription")
    public Response saveRequestDescription(@RequestBody CreateRequestDescriptionRequest createRequestDescriptionRequest){
        log.debug("START saveRequestDescription request body {}",createRequestDescriptionRequest);
        Response response = this.requestDescriptionWritePlatformService.createRequestDescription(createRequestDescriptionRequest);
        log.debug("START saveRequestDescription response",response);
        return response;
    }
    @GetMapping
    public List<RequestDescription> fetchAll() { return this.requestDescriptionReadPlatformService.fetchAllRequestDescription();}

    @GetMapping("/{id}")
    public RequestDescription fetchRequestDescriptionById(@PathVariable(name ="id") Integer id){
        return this.requestDescriptionReadPlatformService.fetchRequestDescriptionById(id);
    }

    @PutMapping("/{id}")
    public Response updateRequestDescription(@PathVariable Integer id, @RequestBody UpdateRequestDescriptionRequest updateRequestDescriptionRequest){
        log.debug("START updateRequestDescription request body {}",updateRequestDescriptionRequest);
        Response response = this.requestDescriptionWritePlatformService.updateRequestDescription(id,updateRequestDescriptionRequest);
        log.debug("START updateRequestDescription response",response);
        return response;
    }

    @PutMapping("/{id}/block")
    public Response blockRequestDescription(@PathVariable Integer id){
        Response response = this.requestDescriptionWritePlatformService.blockRequestDescription(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockRequestDescription(@PathVariable Integer id){
        Response response = this.requestDescriptionWritePlatformService.unblockRequestDescription(id);
        return response;
    }
}
