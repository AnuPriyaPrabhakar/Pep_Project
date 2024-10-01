package com.ponsun.pep.spouse.SpouseCommonService.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
public class SpouseCommonDTO {
    private SpouseDetailsDTO spouseDetailsDTO;
    private List<SpouseHufDTO> spouseHufDTOS;
    private List<SpouseFatherDTO> spouseFatherDTOS;
    private List<SpouseMotherDTO> spouseMotherDTOS;

    public SpouseCommonDTO (SpouseDetailsDTO spouseDetailsDTO, List<SpouseHufDTO> spouseHufDTOS , List<SpouseFatherDTO> spouseFatherDTOS ,List<SpouseMotherDTO> spouseMotherDTOS ) {
        this.spouseDetailsDTO = spouseDetailsDTO;
        this.spouseHufDTOS = spouseHufDTOS;
        this.spouseFatherDTOS = spouseFatherDTOS;
        this.spouseMotherDTOS = spouseMotherDTOS;
    }

    public SpouseCommonDTO newInstance (SpouseDetailsDTO spouseDetailsDTO, List<SpouseHufDTO> spouseHufDTOS , List<SpouseFatherDTO> spouseFatherDTOS ,List<SpouseMotherDTO> spouseMotherDTOS ) {
        return new SpouseCommonDTO(spouseDetailsDTO , spouseHufDTOS , spouseFatherDTOS,spouseMotherDTOS);
    }
}
