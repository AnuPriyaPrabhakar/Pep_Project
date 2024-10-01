package com.ponsun.pep.familyDetails.FatherDetails.api;



import com.ponsun.pep.familyDetails.FatherDetails.domain.FatherDetails;
import com.ponsun.pep.familyDetails.FatherDetails.request.CreateFatherDetailsRequest;
import com.ponsun.pep.familyDetails.FatherDetails.request.UpdateFatherDetailsRequest;
import com.ponsun.pep.familyDetails.FatherDetails.services.FatherDetailsReadPlatFormService;
import com.ponsun.pep.familyDetails.FatherDetails.services.FatherDetailsWritePlatFormService;
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
@RequestMapping("/api/v1/FatherDetails")
@Tag(name="FatherDetailsApiResource")
public class FatherDetailsApiResource {
    private final FatherDetailsReadPlatFormService fatherDetailsReadPlatFormService;
    private final FatherDetailsWritePlatFormService fatherDetailsWritePlatFormService;

    @PostMapping("/CreateFatherDetailsRequest")
    public Response saveFatherDetails(@RequestBody CreateFatherDetailsRequest createFatherDetailsRequest){
        Response response = this.fatherDetailsWritePlatFormService.createFatherDetails(createFatherDetailsRequest);
        return response;
    }
    @GetMapping
    public List<FatherDetails> fetchAll(){return this.fatherDetailsReadPlatFormService.fetchAllFatherDetails();}

    @GetMapping("/{id}")
    public FatherDetails fetchFatherDetailsById(@PathVariable(name = "id")Integer id){
        return this.fatherDetailsReadPlatFormService.fetchFatherDetailsById(id);

    }
    @PutMapping("/{id}")
    public Response updateFatherDetails(@PathVariable Integer id, @RequestBody UpdateFatherDetailsRequest updateFatherDetailsRequest){
        Response response = this.fatherDetailsWritePlatFormService.updateFatherDetailsList(id, updateFatherDetailsRequest);
        return response;
    }
    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer pepId, @RequestParam Integer euid){
        Response response = this.fatherDetailsWritePlatFormService.DeActiveFamily(pepId, euid);
        return response;
    }

}
