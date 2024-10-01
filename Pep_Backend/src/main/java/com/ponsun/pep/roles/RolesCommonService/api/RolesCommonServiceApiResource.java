package com.ponsun.pep.roles.RolesCommonService.api;

import com.ponsun.pep.roles.Role.data.RoleData;
import com.ponsun.pep.roles.Role.request.CreateRoleRequest;
import com.ponsun.pep.roles.Role.request.UpdateRoleRequest;
import com.ponsun.pep.roles.Role.services.RoleWritePlatformServiceImpl;
import com.ponsun.pep.roles.RolesCommonService.service.RoleCommonReadPlatformService;
import com.ponsun.pep.roles.RolesCommonService.service.RoleCommonWritePlatformService;
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
@RequestMapping("api/v1/RolesCommonService")
@Tag(name = "RolesCommonServiceApiResource")
public class RolesCommonServiceApiResource {

    private final RoleCommonWritePlatformService roleCommonWritePlatformService;
    private final RoleCommonReadPlatformService roleCommonReadPlatformService;
    @PostMapping("/saveRoleDetails")
    public Response saveRoleDetails(@RequestBody CreateRoleRequest createRoleRequest) {
        return roleCommonWritePlatformService.createRoleDetails(createRoleRequest);
    }
    @PutMapping("/{id}")
    public Response updateRole(@PathVariable Integer id, @RequestBody CreateRoleRequest createRoleRequest){
        log.debug("START updateRole request body {}",createRoleRequest);
        Response response = this.roleCommonWritePlatformService.createAndUpdateRoleDetails(id,createRoleRequest);
        log.debug("START updateRole response",response);
        return response;
    }
    @GetMapping("/Active")
    public List<RoleData> fetchActiveRoleData(){
        return this.roleCommonReadPlatformService.fetchRoleData();
    }
}
