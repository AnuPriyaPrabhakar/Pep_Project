package com.ponsun.pep.familyDetails.MotherDetails.api;

import com.ponsun.pep.familyDetails.MotherDetails.domain.MotherDetails;
import com.ponsun.pep.familyDetails.MotherDetails.request.CreateMotherDetailsRequest;
import com.ponsun.pep.familyDetails.MotherDetails.request.UpdateMotherDetailsRequest;
import com.ponsun.pep.familyDetails.MotherDetails.services.MotherDetailsReadPlatformService;
import com.ponsun.pep.familyDetails.MotherDetails.services.MotherDetailsWritePlatformService;
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
@RequestMapping("/api/v1/MotherDetails")
@Tag(name = "MotherDetailsApiResource")
public class MotherDetailsApiResource {

    private final MotherDetailsReadPlatformService motherDetailsReadPlatFormService;
    private final MotherDetailsWritePlatformService motherDetailsWritePlatFormService;

    @PostMapping("/CreateMotherDetailsRequest")
    public Response saveMotherDetails(@RequestBody CreateMotherDetailsRequest createMotherDetailsRequest) {
        Response response = this.motherDetailsWritePlatFormService.createMotherDetails(createMotherDetailsRequest);
        return response;
    }

    @GetMapping
    public List<MotherDetails> fetchAll() {
        return this.motherDetailsReadPlatFormService.fetchAllMotherDetails();
    }

    @GetMapping("/{id}")
    public MotherDetails fetchMotherDetailsById(@PathVariable(name = "id") Integer id) {
        return this.motherDetailsReadPlatFormService.fetchMotherDetailsById(id);

    }

    @PutMapping("/{id}")
    public Response updateMotherDetails(@PathVariable Integer id, @RequestBody UpdateMotherDetailsRequest updateMotherDetailsRequest) {
        Response response = this.motherDetailsWritePlatFormService.updateMotherDetails(id, updateMotherDetailsRequest);
        return response;
    }
}
