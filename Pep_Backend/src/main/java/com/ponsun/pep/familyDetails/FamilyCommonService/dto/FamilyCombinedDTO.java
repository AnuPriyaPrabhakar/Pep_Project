package com.ponsun.pep.familyDetails.FamilyCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class FamilyCombinedDTO {
    private List<HufDTO> hufDTO;
    private List<FatherDTO> fatherDTOS;
    private List<MotherDTO> motherDTOS;

    public FamilyCombinedDTO (List<HufDTO> hufDTO, List<FatherDTO> fatherDTOS , List<MotherDTO> motherDTOS) {
        this.hufDTO = hufDTO;
        this.fatherDTOS = fatherDTOS;
        this.motherDTOS = motherDTOS;
    }

    public FamilyCombinedDTO newInstance (List<HufDTO> hufDTO, List<FatherDTO> fatherDTOS , List<MotherDTO> motherDTOS) {
        return new FamilyCombinedDTO(hufDTO , fatherDTOS , motherDTOS);
    }

}
