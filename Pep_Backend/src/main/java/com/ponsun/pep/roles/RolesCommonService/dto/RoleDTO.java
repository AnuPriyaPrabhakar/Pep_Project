package com.ponsun.pep.roles.RolesCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RoleDTO {
    private String roleName;
    private Integer uid;
    private Integer euid;

    public RoleDTO(String roleName,  Integer uid, Integer euid) {
        this.roleName = roleName;
        this.uid = uid;
        this.euid = euid;
    }

    public static RoleDTO newInstance(final String roleName,  final Integer uid, final Integer euid) {
        return new RoleDTO(roleName, uid, euid);
    }
}
