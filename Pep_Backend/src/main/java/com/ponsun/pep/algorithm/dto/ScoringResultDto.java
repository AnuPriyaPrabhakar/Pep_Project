package com.ponsun.pep.algorithm.dto;


import com.ponsun.pep.dto.RecordDTO;
import com.ponsun.pep.dto.SearchDTO;
import lombok.Data;

import java.util.List;

@Data
public class ScoringResultDto {
    private SearchDTO searchDTO;
    private List<RecordDTO> recordDTO;

    public ScoringResultDto(SearchDTO searchDTO, List<RecordDTO> recordDTO) {
        this.searchDTO = searchDTO;
        this.recordDTO = recordDTO;
    }
    public static ScoringResultDto newInstance(SearchDTO searchDTO, List<RecordDTO> recordDTO){
        return new ScoringResultDto(searchDTO,recordDTO);
    }
}
