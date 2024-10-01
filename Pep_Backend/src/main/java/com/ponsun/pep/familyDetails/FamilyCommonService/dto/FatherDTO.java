package com.ponsun.pep.familyDetails.FamilyCommonService.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class FatherDTO {
    private Integer pepId;
    private String fatherName;
    private String fatherPan;
    private Integer uid;
    private Integer euid;

    public FatherDTO (final Integer pepId,  final String fatherName , final String fatherPan ,final Integer uid , final Integer euid ) {
        this.pepId = pepId;
        this.fatherName = fatherName;
        this.fatherPan = fatherPan;
        this.uid = uid;
        this.euid = euid;
    }
    public static FatherDTO newInstance (final Integer pepId, final String fatherName , final String fatherPan , final Integer uid , final Integer euid ) {
        return new FatherDTO(pepId,fatherName,fatherPan,uid,euid);
    }
}
