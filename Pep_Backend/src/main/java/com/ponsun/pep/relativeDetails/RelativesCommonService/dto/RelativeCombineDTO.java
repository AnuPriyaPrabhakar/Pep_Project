package com.ponsun.pep.relativeDetails.RelativesCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Data
public class RelativeCombineDTO {
    private RelativeDTO relativeDTO;
    private List<RelativeDetDTO> relativeDetDTOS;
    private List<RelativeChildrenDTO> relativeChildrenDTOS;

    public RelativeCombineDTO(RelativeDTO relativeDTO, List<RelativeDetDTO> relativeDetDTOS , List<RelativeChildrenDTO> relativeChildrenDTOS) {
        this.relativeDTO = relativeDTO;
        this.relativeDetDTOS = relativeDetDTOS;
        this.relativeChildrenDTOS = relativeChildrenDTOS;

    }
    public RelativeCombineDTO newInstance(RelativeDTO relativeDTO , List<RelativeDetDTO> relativeDetDTOS , List<RelativeChildrenDTO> relativeChildrenDTOS) {
        return new RelativeCombineDTO(relativeDTO , relativeDetDTOS , relativeChildrenDTOS);
    }
}
