package com.ponsun.pep.spouse.SpouseCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class SpouseFatherDTO {

    private Integer id;
    private Integer pepId;
    private Integer spouseId;
    private String fatherName;
    private String fatherPan;
    private Integer uid;
    private Integer euid;

    public SpouseFatherDTO(final Integer id, final Integer pepId, final Integer spouseId, final String fatherName, final String fatherPan, final Integer uid, final Integer euid ) {
        this.id=id;
        this.pepId=pepId;
        this.spouseId = spouseId;
        this.fatherName=fatherName;
        this.fatherPan=fatherPan;
        this.uid=uid;
        this.euid=euid;

    }
    public static SpouseFatherDTO newInstance(final Integer id, final Integer pepId, final Integer spouseId, final String fatherName, final String fatherPan, final Integer uid, final Integer euid ) {
        return new SpouseFatherDTO(id,pepId,spouseId,fatherName,fatherPan,uid,euid);
    }

}
