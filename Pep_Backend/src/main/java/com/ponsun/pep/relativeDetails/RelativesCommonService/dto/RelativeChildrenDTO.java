package com.ponsun.pep.relativeDetails.RelativesCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class RelativeChildrenDTO {
    private Integer pepId;
    private Integer relativeId;
    private Integer relativeDetId;
    private String childrenName;
    private String pan;
    private Integer uid;
    private Integer euid;

    public RelativeChildrenDTO(Integer pepId, Integer relativeId, Integer relativeDetId, String childrenName, String pan, Integer uid, Integer euid) {
        this.pepId = pepId;
        this.relativeId = relativeId;
        this.relativeDetId = relativeDetId;
        this.childrenName = childrenName;
        this.pan = pan;
        this.uid = uid;
        this.euid = euid;
    }
    public static RelativeChildrenDTO newInstance (final Integer pepId , final Integer relativeId, final Integer relativeDetId , final String childrenName , final String pan, final Integer uid, final Integer euid ) {
        return new RelativeChildrenDTO(pepId,relativeId,relativeDetId,childrenName,pan,uid,euid);
    }

}