package com.ponsun.pep.spouse.spouseDetails.api;

import com.ponsun.pep.spouse.spouseDetails.domain.SpouseDetails;
import com.ponsun.pep.spouse.spouseDetails.request.CreateSpouseDetailsRequest;
import com.ponsun.pep.spouse.spouseDetails.request.UpdateSpouseDetailsRequest;
import com.ponsun.pep.spouse.spouseDetails.services.SpouseDetailsReadPlatformService;
import com.ponsun.pep.spouse.spouseDetails.services.SpouseDetailsWritePlatformService;
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
@RequestMapping("/api/v1/SpouseDetails")
@Tag(name = "SpouseDetailsApiResource")
public class SpouseDetailsApiResource {

    private final SpouseDetailsReadPlatformService spouseDetailsReadPlatFormService;
    private final SpouseDetailsWritePlatformService spouseDetailsWritePlatFormService;

    @PostMapping("/CreateSpouseDetailsRequest")
    public Response saveSpouseDetails(@RequestBody CreateSpouseDetailsRequest createSpouseDetailsRequest){
        Response response = this.spouseDetailsWritePlatFormService.createSpouseDetails(createSpouseDetailsRequest);
        return response;
    }
    @GetMapping
    public List<SpouseDetails> fetchAll(){return this.spouseDetailsReadPlatFormService.fetchAllSpouseDetails();}

    @GetMapping("/{id}")
    public SpouseDetails fetchSpouseDetailsById(@PathVariable(name = "id")Integer id){
        return this.spouseDetailsReadPlatFormService.fetchSpouseDetailsById(id);

    }
    @PutMapping("/{id}")
    public Response updateSpouseDetails(@PathVariable Integer id, @RequestBody UpdateSpouseDetailsRequest updateSpouseDetailsRequest){
        Response response = this.spouseDetailsWritePlatFormService.updateSpouseDetails(id, updateSpouseDetailsRequest);
        return response;
    }
}
