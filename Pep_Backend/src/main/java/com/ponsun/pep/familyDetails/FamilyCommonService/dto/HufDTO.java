package com.ponsun.pep.familyDetails.FamilyCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class HufDTO {
    private Integer pepId;
    private String hufName;
    private String hufPan;
    private Integer uid;
    private Integer euid;

    public HufDTO (final Integer pepId,  String hufName , String hufPan ,  final Integer uid , final Integer euid ) {
        this.pepId = pepId;
        this.hufName = hufName;
        this.hufPan = hufPan;
        this.uid = uid;
        this.euid = euid;
    }
    public static HufDTO newInstance (final Integer pepId, String hufName , String hufPan , final Integer uid , final Integer euid ) {
        return new HufDTO(pepId,hufName,hufPan,uid,euid);
    }

}
