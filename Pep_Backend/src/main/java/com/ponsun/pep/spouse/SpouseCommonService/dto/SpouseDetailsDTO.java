package com.ponsun.pep.spouse.SpouseCommonService.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SpouseDetailsDTO {

    private Integer id;
    private Integer pepId;
    private String spouseName;
    private String spousePan;
    private Integer uid;
    private Integer euid;

    public SpouseDetailsDTO (final Integer id ,final Integer pepId,  final String spouseName , String spousePan ,  final Integer uid , final Integer euid ) {
        this.id = id;
        this.pepId = pepId;
        this.spouseName = spouseName;
        this.spousePan = spousePan;
        this.uid = uid;
        this.euid = euid;
    }
    public static SpouseDetailsDTO newInstance (final Integer id,final Integer pepId,  final String spouseName , String spousePan , final Integer uid , final Integer euid ) {
        return new SpouseDetailsDTO(id,pepId,spouseName,spousePan,uid,euid);
    }
}
