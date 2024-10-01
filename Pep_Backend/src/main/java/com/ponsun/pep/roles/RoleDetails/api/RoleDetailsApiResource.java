package com.ponsun.pep.roles.RoleDetails.api;

import com.ponsun.pep.roles.RoleDetails.domain.RoleDetails;
import com.ponsun.pep.roles.RoleDetails.request.CreateRoleDetailsRequest;
import com.ponsun.pep.roles.RoleDetails.request.UpdateRoleDetailsRequest;
import com.ponsun.pep.roles.RoleDetails.services.RoleDetailsReadPlatformService;
import com.ponsun.pep.roles.RoleDetails.services.RoleDetailsWritePlatformService;
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
@RequestMapping("/api/v1/RoleDetails")
@Tag(name = "RoleDetailsApiResource")
public class RoleDetailsApiResource {
    private final RoleDetailsWritePlatformService roleDetailsWritePlatformService;
    private final RoleDetailsReadPlatformService roleDetailsReadPlatformService;

    @PostMapping("/CreateRoleDetailsRequest")
    public Response saveRoleDetails(@RequestBody CreateRoleDetailsRequest createRoleDetailsRequest){
        Response response = this.roleDetailsWritePlatformService.createRoleDetails(createRoleDetailsRequest);
        return response;
    }
    @GetMapping
    public List<RoleDetails> fetchAll(){return this.roleDetailsReadPlatformService.fetchAllRoleDetails();}

    @GetMapping("/{id}")
    public RoleDetails fetchRoleDetailsById(@PathVariable(name = "id")Integer id){
        return this.roleDetailsReadPlatformService.fetchRoleDetailsById(id);

    }
//    @GetMapping("/pepId/{pepId}")
//    public List<AkaDetData> findByPepId(@PathVariable(name = "pepId") Integer pepId){
//        return this.akaDetReadPlatformService.findBycustomePepId(pepId);
//    }


//    @PutMapping("/deactive/{pepId}")
//    public Response deactive(@PathVariable Integer pepId, Integer euid) {
//        Response response = this.roleDetailsWritePlatformService.deactive(pepId, euid);
//        return response;
//    }

    @PutMapping("/{id}")
    public Response updateRoleDetails(@PathVariable Integer id, @RequestBody UpdateRoleDetailsRequest updateRoleDetailsRequest){
        Response response = this.roleDetailsWritePlatformService.updateRoleDetails(id, updateRoleDetailsRequest);
        return response;
    }
    @PutMapping("/{id}/block")
    public Response blockRoleDetails(@PathVariable Integer id) {
        Response response = this.roleDetailsWritePlatformService.blockRoleDetails(id);
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockRoleDetails(@PathVariable Integer id) {
        Response response = this.roleDetailsWritePlatformService.unblockRoleDetails(id);
        return response;
    }
}

