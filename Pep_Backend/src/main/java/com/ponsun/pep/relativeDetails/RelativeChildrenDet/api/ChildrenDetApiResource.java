package com.ponsun.pep.relativeDetails.RelativeChildrenDet.api;


import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDet;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.CreateChildrenDetRequest;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.UpdateChildrenDetRequest;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.services.ChildrenDetReadPlatformService;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.services.ChildrenDetWritePlatformService;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeChildrenDTO;
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
@RequestMapping("/api/v1/ChildrenDet")
@Tag(name = "ChildrenDetApiResource")
public class ChildrenDetApiResource {

    private final ChildrenDetReadPlatformService childrenDetReadPlatformService;
    private final ChildrenDetWritePlatformService childrenDetWritePlatformService;


    @PostMapping("/CreateChildrenDetRequest")
    public Response saveChildrenDet(@RequestBody CreateChildrenDetRequest createChildrenDetRequest) {
        Response response = this.childrenDetWritePlatformService.createChildrenDet(createChildrenDetRequest);
        return response;
    }
    @GetMapping
    public List<ChildrenDet> fetchAll() {
        return this.childrenDetReadPlatformService.fetchAllChildrenDet();
    }

    @GetMapping("/{id}")
    public ChildrenDet fetchChildrenDetById(@PathVariable(name = "id") Integer id) {
        return this.childrenDetReadPlatformService.fetchChildrenDetById(id);
    }

    @PutMapping("/{id}")
    public Response updateChildrenDet(@PathVariable Integer id, @RequestBody UpdateChildrenDetRequest updateChildrenDetRequest) {
        Response response = this.childrenDetWritePlatformService.updateChildrenDet(id, updateChildrenDetRequest);
        return response;
    }

    @PutMapping("/deactive/{pepId}")
    public Response deactive(@PathVariable Integer pepId, Integer euid) {
        Response response = this.childrenDetWritePlatformService.deactive(pepId, euid);
        return response;
    }


    @DeleteMapping("/{id}")
    public Response deleteChildrenDet(@PathVariable(name = "id") Integer id) {
        Response response = this.childrenDetWritePlatformService.deleteChildrenDet(id);
        return response;
    }

//    @GetMapping("/{PepId}")
//    public List<RelativeChildrenDTO>  fetchRelativeChildrenDTO(@PathVariable(name = "PepId") Integer pepId) {
//        return this.childrenDetWritePlatformService.fetchRelativeChildrenDTO(pepId);
//    }
}
