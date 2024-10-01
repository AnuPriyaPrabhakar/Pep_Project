package com.ponsun.pep.spouse.SpouseCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class SpouseMotherDTO {
    private Integer id;
    private Integer pepId;
    private Integer spouseId;
    private String motherName;
    private String motherPan;
    private Integer uid;
    private Integer euid;

    public SpouseMotherDTO(final Integer id, final Integer pepId, final Integer spouseId, final String motherName, final String motherPan, final Integer uid, final Integer euid ) {
        this.id=id;
        this.pepId=pepId;
        this.spouseId = spouseId;
        this.motherName=motherName;
        this.motherPan=motherPan;
        this.uid=uid;
        this.euid=euid;

    }
    public static SpouseMotherDTO newInstance(final Integer id, final Integer pepId, final Integer spouseId, final String motherName, final String motherPan, final Integer uid, final Integer euid ) {
        return new SpouseMotherDTO(id,pepId,spouseId,motherName,motherPan,uid,euid);
    }
}
