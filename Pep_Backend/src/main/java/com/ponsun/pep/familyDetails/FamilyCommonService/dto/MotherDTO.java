package com.ponsun.pep.familyDetails.FamilyCommonService.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class MotherDTO {
    //private Integer id;
    private Integer pepId;
    private String motherName;
    private String motherPan;
    private Integer uid;
    private Integer euid;

    public MotherDTO (final Integer pepId,   final String motherName , String motherPan ,  final Integer uid , final Integer euid ) {
        this.pepId = pepId;
        this.motherName = motherName;
        this.motherPan = motherPan;
        this.uid = uid;
        this.euid = euid;
    }
    public static MotherDTO newInstance (final Integer pepId,  final String motherName , String motherPan , final Integer uid , final Integer euid ) {
        return new MotherDTO(pepId,motherName,motherPan,uid,euid);
    }
}
