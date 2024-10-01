package com.ponsun.pep.relativeDetails.Relative.api;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.relativeDetails.Relative.domain.Relative;
import com.ponsun.pep.relativeDetails.Relative.request.CreateRelativeRequest;
import com.ponsun.pep.relativeDetails.Relative.request.UpdateRelativeRequest;
import com.ponsun.pep.relativeDetails.Relative.services.RelativeReadPlatformService;
import com.ponsun.pep.relativeDetails.Relative.services.RelativeWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/Relative")
@Tag(name = "RelativeApiResourceDet")
public class RelativeApiResource {

    private final RelativeWritePlatformService relativeWritePlatformService;
    private final RelativeReadPlatformService relativeReadPlatformService;

    @PostMapping("/CreateRelativeRequest")
    public Response saveRelative(@RequestBody CreateRelativeRequest createRelativeRequest){
        Response response =this.relativeWritePlatformService.createRelative(createRelativeRequest);
        return response;
    }
    @GetMapping
    public List<Relative>fetchAll(){
        return this.relativeReadPlatformService.fetchAllRelative();
    }
//    @GetMapping("/{id}")
//    public Relative fetchRelativeById(@PathVariable(name = "id") Integer id){
//        return this.relativeReadPlatformService.fetchRelativeById(id);
//    }
    @PutMapping("/{id}")
    public Response updateRelative(@PathVariable Integer id, @RequestBody UpdateRelativeRequest updateRelativeRequest){
        Response response = this.relativeWritePlatformService.updateRelative(id,updateRelativeRequest);
        return response;

    }


    @PutMapping("/deactive/{pepId}")
    public Response deactive(@PathVariable Integer pepId , Integer relativeMasterId,Integer euid) {
        Response response = this.relativeWritePlatformService.DeactiveRelative(pepId , euid);
        return response;
    }

    @PutMapping("/{id}/block")
    public Response blockRelative(@PathVariable Integer id) {
        Response response = this.relativeWritePlatformService.blockRelative(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockRelative(@PathVariable Integer id) {
        Response response = this.relativeWritePlatformService.unblockRelative(id);
        return response;
    }

}
