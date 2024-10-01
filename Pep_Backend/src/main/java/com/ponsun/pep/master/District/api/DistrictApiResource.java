package com.ponsun.pep.master.District.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.District.domain.District;
import com.ponsun.pep.master.District.request.CreateDistrictRequest;
import com.ponsun.pep.master.District.request.UpdateDistrictRequest;
import com.ponsun.pep.master.District.services.DistrictReadPlatformService;
import com.ponsun.pep.master.District.services.DistrictWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/District")
@Tag(name = "DistrictApiResource")
public class DistrictApiResource {

    private final DistrictReadPlatformService districtReadPlatformService;
    private final DistrictWritePlatformService districtWritePlatformService;
    @PostMapping("/CreateDistrictRequest")
    public Response saveDistrict(@RequestBody CreateDistrictRequest createDistrictRequest) {
        log.debug("START saveDistrict request body {}",createDistrictRequest);
        Response response = this.districtWritePlatformService.createDistrict(createDistrictRequest);
        log.debug("START saveDistrict response",response);
        return response;
    }
    @GetMapping
    public List<District> fetchAll() {
        return this.districtReadPlatformService.fetchAllDistrict();
    }

    @GetMapping("/{id}")
    public District fetchDistrictById(@PathVariable(name = "id") Integer id) {
        return this.districtReadPlatformService.fetchDistrictById(id);
    }

    @PutMapping("/{id}")
    public Response updateDistrict(@PathVariable Integer id, @RequestBody UpdateDistrictRequest updateDistrictRequest) {
        log.debug("START updateDistrict request body {}",updateDistrictRequest);
        Response response = this.districtWritePlatformService.updateDistrict(id, updateDistrictRequest);
        log.debug("START updateDistrict response",response);
        return response;
    }

    @PutMapping("/{id}/block")
    public Response blockDistrict(@PathVariable Integer id) {
        Response response = this.districtWritePlatformService.blockDistrict(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockDistrict(@PathVariable Integer id) {
        Response response = this.districtWritePlatformService.unblockDistrict(id);
        return response;
    }
}
