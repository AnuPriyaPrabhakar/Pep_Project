package com.ponsun.pep.relativeDetails.Relativedet.api;

import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDetDTO;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDet;
import com.ponsun.pep.relativeDetails.Relativedet.request.CreateRelativeDetRequest;
import com.ponsun.pep.relativeDetails.Relativedet.request.UpdateRelativeDetRequest;
import com.ponsun.pep.relativeDetails.Relativedet.services.RelativeDetReadPlatformService;
import com.ponsun.pep.relativeDetails.Relativedet.services.RelativeDetWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/RelativeDetApiResource")
@Tag(name = "RelativeDetApiResource")
public class RelativeDetApiResource {

    private final RelativeDetWritePlatformService relativeDetWritePlatformService;
    private final RelativeDetReadPlatformService relativeDetReadPlatformService;
    @PostMapping("/CreateRelativeDetRequest")
    public Response saveRelativeDet(@RequestBody CreateRelativeDetRequest createRelativeDetRequest){
     Response response = this.relativeDetWritePlatformService.createRelativeDet(createRelativeDetRequest);
     return response;
    }

    @GetMapping
    public List<RelativeDet>fetchAll(){
        return this.relativeDetReadPlatformService.fetchAllRelativeDet();
    }

    @GetMapping("/{id}")
    public RelativeDet fetchRelativeDetById(@PathVariable (name = "id")Integer id){
        return this.relativeDetReadPlatformService.fetchRelativeDetById(id);
    }
    @PutMapping("/{id}")
    public Response updateRelativeDet(@PathVariable Integer id, @RequestBody UpdateRelativeDetRequest updateRelativeDetRequest ) {
        Response response = this.relativeDetWritePlatformService.updateRelativeDet(id, updateRelativeDetRequest);
        return response;
    }

    @PutMapping("/{id}/block")
    public Response blockRelativeDet(@PathVariable Integer id) {
        Response response = this.relativeDetWritePlatformService.blockRelativeDet(id);
        return response;
    }

    @PutMapping("/deactive/{pepId}")
    public Response deactive(@PathVariable Integer pepId, Integer euid) {
        Response response = this.relativeDetWritePlatformService.deactive(pepId, euid);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockRelativeDet(@PathVariable Integer id) {
        Response response = this.relativeDetWritePlatformService.unblockRelativeDet(id);
        return response;
    }

//    @GetMapping("/{PepId}")
//    public List<RelativeDetDTO>  fetchRelativeDetDTO(@PathVariable(name = "PepId") Integer pepId) {
//        return this.relativeDetWritePlatformService.fetchRelativeDetDTO(pepId);
//    }
}
