package com.ponsun.pep.roles.Role.api;


import com.ponsun.pep.roles.Role.data.RoleData;
import com.ponsun.pep.roles.Role.domain.Role;
import com.ponsun.pep.roles.Role.request.CreateRoleRequest;
import com.ponsun.pep.roles.Role.request.UpdateRoleRequest;
import com.ponsun.pep.roles.Role.services.RoleReadPlatformService;
import com.ponsun.pep.roles.Role.services.RoleWritePlatformService;
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
@RequestMapping("api/v1/Role")
@Tag(name = "RoleApiResource")
public class RoleApiResource {
    private final RoleReadPlatformService roleReadPlatformService;
    private final RoleWritePlatformService roleWritePlatformService;

    @PostMapping("/CreateRole")
    public Response saveRole(@RequestBody CreateRoleRequest createRoleRequest){
        Response response =this.roleWritePlatformService.createRole(createRoleRequest);
        return response;
    }

    @GetMapping
    public List<Role> fetchAll(){
        return this.roleReadPlatformService.fetchAllRole();
    }

    @GetMapping("/{id}")
    public Role fetchRole(@PathVariable(name = "id") Integer id) {
        return this.roleReadPlatformService.fetchRoleById(id);
    }

    @PutMapping("/{id}")
    public Response updateRole(@PathVariable Integer id, @RequestBody UpdateRoleRequest updateRoleRequest){
        log.debug("START updateRole request body {}",updateRoleRequest);
        Response response = this.roleWritePlatformService.updateRole(id,updateRoleRequest);
        log.debug("START updateRole response",response);
        return response;
    }


}
