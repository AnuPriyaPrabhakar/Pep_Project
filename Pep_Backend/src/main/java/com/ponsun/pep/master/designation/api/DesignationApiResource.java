package com.ponsun.pep.master.designation.api;


import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.designation.domain.Designation;
import com.ponsun.pep.master.designation.request.CreateDesignationRequest;
import com.ponsun.pep.master.designation.request.UpdateDesignationRequest;
import com.ponsun.pep.master.designation.services.DesignationReadPlatformService;
import com.ponsun.pep.master.designation.services.DesignationWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/Designation")
@Tag(name = "DesignationApiResource")
public class DesignationApiResource {
    private final DesignationWritePlatformService designationWritePlatformService;

    private final DesignationReadPlatformService designationReadPlatformService;

    @PostMapping("/CreateDesignationRequest")
    public Response saveDesignation(@RequestBody CreateDesignationRequest createDesignationRequest) {
        Response response = this.designationWritePlatformService.createDesignation(createDesignationRequest);
        return response;
    }

    @GetMapping
    public List<Designation> fetchAll() {
        return this.designationReadPlatformService.fetchAllDesignation();
    }

    @GetMapping("/{id}")
    public Designation fetchDesignationById(@PathVariable(name = "id") Integer id) {
        return this.designationReadPlatformService.fetchDesignationById(id);
    }
    @PutMapping("/{id}")
    public Response updateDesignation(@PathVariable Integer id, @RequestBody UpdateDesignationRequest updateDesignationRequest) {
        Response response = this.designationWritePlatformService.updateDesignation(id, updateDesignationRequest);
        return response;
    }

}




