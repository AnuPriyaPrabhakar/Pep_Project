package com.ponsun.pep.spouse.SpouseCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class SpouseHufDTO {

    private Integer id;
    private Integer pepId;
    private Integer spouseId;
    private String hufName;
    private String hufPan;
    private Integer uid;
    private Integer euid;

    public SpouseHufDTO (final Integer id, final Integer pepId,final Integer spouseId, final String hufName, final String hufPan,final Integer uid,final Integer euid ) {
        this.id=id;
        this.pepId=pepId;
        this.spouseId=spouseId;
        this.hufName=hufName;
        this.hufPan=hufPan;
        this.uid=uid;
        this.euid=euid;

    }
    public static SpouseHufDTO newInstance (final Integer id, final Integer pepId, final Integer spouseId, final String hufName, final String hufPan, final Integer uid, final Integer euid ) {
        return new SpouseHufDTO(id,pepId,spouseId,hufName,hufPan,uid,euid);
    }
}
