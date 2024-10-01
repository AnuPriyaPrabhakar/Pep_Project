package com.ponsun.pep.roles.Role.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class AbstractRoleRequest {
    private Integer id;
    private String roleName;
    private Integer uid;
    private Integer euid;

}
