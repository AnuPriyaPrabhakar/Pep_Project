package com.ponsun.pep.relativeDetails.FamilyDocuments.api;

import com.ponsun.pep.relativeDetails.FamilyDocuments.domain.FamilyDocuments;
import com.ponsun.pep.relativeDetails.FamilyDocuments.request.CreateFamilyDocumentsRequest;
import com.ponsun.pep.relativeDetails.FamilyDocuments.request.UpdateFamilyDocumentsRequest;
import com.ponsun.pep.relativeDetails.FamilyDocuments.services.FamilyDocumentsReadPlatformService;
import com.ponsun.pep.relativeDetails.FamilyDocuments.services.FamilyDocumentsWritePlatformService;
import com.ponsun.pep.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api/v1/FamilyDocuments")
@Tag(name = "FamilyDocumentsApiResource")
public class FamilyDocumentsApiResource {

    private final FamilyDocumentsWritePlatformService familyDocumentsWritePlatformService;
    private final FamilyDocumentsReadPlatformService familyDocumentsReadPlatformService;


    @PostMapping("/CreateFamilyDocuments")
    public Response saveFamilyDocuments(@RequestBody CreateFamilyDocumentsRequest createFamilyDocumentsRequest){
        Response response = this.familyDocumentsWritePlatformService.createFamilyDocuments(createFamilyDocumentsRequest);
        return response;
    }

    @GetMapping
    public List<FamilyDocuments> fetchAll(){return this.familyDocumentsReadPlatformService.fetchAllFamilyDocuments();}

    @GetMapping("/{id}")
    public FamilyDocuments fetchFamilyDocumentsById(@PathVariable(name = "id")Integer id){
        return this.familyDocumentsReadPlatformService.fetchFamilyDocumentsById(id);
    }

    @PutMapping("/{id}")
    public Response updateFamilyDocuments(@PathVariable Integer id, @RequestBody UpdateFamilyDocumentsRequest updateFamilyDocumentsRequest){
        Response response = this.familyDocumentsWritePlatformService.updateFamilyDocuments(id, updateFamilyDocumentsRequest);
        return response;
    }
}
