package com.ponsun.pep.familyDetails.HufDetails.api;

import com.ponsun.pep.familyDetails.HufDetails.domain.HufDetails;
import com.ponsun.pep.familyDetails.HufDetails.request.CreateHufDetailsRequest;
import com.ponsun.pep.familyDetails.HufDetails.request.UpdateHufDetailsRequest;
import com.ponsun.pep.familyDetails.HufDetails.services.HufDetailsReadPlatFormService;
import com.ponsun.pep.familyDetails.HufDetails.services.HufDetailsWritePlatFormService;
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
@RequestMapping("/api/v1/HufDetails")
@Tag(name = "HufDetailsApiResource")
public class HufDetailsApiResource {

    private final HufDetailsReadPlatFormService hufDetailsReadPlatFormService;
    private final HufDetailsWritePlatFormService hufDetailsWritePlatFormService;

    @PostMapping("/CreateHufDetailsRequest")
    public Response saveHufDetails(@RequestBody CreateHufDetailsRequest createHufDetailsRequest){
        Response response = this.hufDetailsWritePlatFormService.createHufDetails(createHufDetailsRequest);
        return response;
    }
    @GetMapping
    public List<HufDetails> fetchAll(){return this.hufDetailsReadPlatFormService.fetchAllHufDetails();}

    @GetMapping("/{id}")
    public HufDetails fetchHufDetailsById(@PathVariable(name = "id")Integer id){
        return this.hufDetailsReadPlatFormService.fetchHufDetailsById(id);

    }
    @PutMapping("/{id}")
    public Response updateHufDetails(@PathVariable Integer id, @RequestBody UpdateHufDetailsRequest updateHufDetailsRequest){
        Response response = this.hufDetailsWritePlatFormService.updateHufDetailsList(id, updateHufDetailsRequest);
        return response;
    }
}
