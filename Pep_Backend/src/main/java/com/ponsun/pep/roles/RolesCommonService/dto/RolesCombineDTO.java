package com.ponsun.pep.roles.RolesCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
@Data
public class RolesCombineDTO {
    private List<RoleDTO> roleDTOS;
    private List<RoleDetailsDTO> roleDetailsDTOS;

    public RolesCombineDTO( List<RoleDTO> roleDTOS , List<RoleDetailsDTO> roleDetailsDTOS) {
        this.roleDTOS = roleDTOS;
        this.roleDetailsDTOS = roleDetailsDTOS;
    }

    public RolesCombineDTO newInstance(List<RoleDTO> roleDTOS , List<RoleDetailsDTO> roleDetailsDTOS) {
        return new RolesCombineDTO(roleDTOS , roleDetailsDTOS);
    }
}
