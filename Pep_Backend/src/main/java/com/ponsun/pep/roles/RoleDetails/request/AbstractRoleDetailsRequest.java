package com.ponsun.pep.roles.RoleDetails.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class AbstractRoleDetailsRequest {
    private Integer id;
    private Integer roleId;
    private Integer modId;
    private Integer modDetId;
    private Integer uid;
    private Integer euid;
}
