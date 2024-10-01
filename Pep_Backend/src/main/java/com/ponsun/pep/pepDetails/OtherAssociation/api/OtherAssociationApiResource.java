package com.ponsun.pep.pepDetails.OtherAssociation.api;

import com.ponsun.pep.pepDetails.OtherAssociation.domain.OtherAssociation;
import com.ponsun.pep.pepDetails.OtherAssociation.request.CreateOtherAssociationRequest;
import com.ponsun.pep.pepDetails.OtherAssociation.request.UpdateOtherAssociationRequest;
import com.ponsun.pep.pepDetails.OtherAssociation.services.OtherAssociationReadPlatformService;
import com.ponsun.pep.pepDetails.OtherAssociation.services.OtherAssociationWritePlatformService;
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
@RequestMapping("api/v1/OtherAssociation")
@Tag(name = "OtherAssociationApiResource")
public class OtherAssociationApiResource {
    private final OtherAssociationWritePlatformService otherAssociationWritePlatformService;
    private final OtherAssociationReadPlatformService otherAssociationReadPlatformService;
    @PostMapping("/CreateOtherAssociationRequest")
    public Response saveOtherAssociation(@RequestBody CreateOtherAssociationRequest createOtherAssociationRequest){
        Response response = this.otherAssociationWritePlatformService.createOtherAssociation(createOtherAssociationRequest);
        return response;
    }
    @GetMapping
    public List<OtherAssociation> fetchAll(){ return this.otherAssociationReadPlatformService.fetchAllOtherAssociation();}
    @GetMapping("/{id}")
    public OtherAssociation fetchOtherAssociationById(@PathVariable(name ="id")Integer id){
        return this.otherAssociationReadPlatformService.fetchOtherAssociationById(id);
    }
    @PutMapping("/{id}")
    public Response updateOtherAssociation(@PathVariable Integer id, @RequestBody UpdateOtherAssociationRequest updateOtherAssociationRequest){
       Response response= this.otherAssociationWritePlatformService.updateOtherAssociation(id,updateOtherAssociationRequest);
       return response;
    }
    @PutMapping("/{id}/block")
    public Response blockOtherAssociation(@PathVariable Integer id){
        Response response = this.otherAssociationWritePlatformService.blockOtherAssociation(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockOtherAssociation(@PathVariable Integer id){
        Response response = this.otherAssociationWritePlatformService.unblockOtherAssociation(id);
        return response;
    }

    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer pepId , @RequestParam Integer euid){
        Response response = this.otherAssociationWritePlatformService.deactive(pepId , euid);
        return response;
    }
}
