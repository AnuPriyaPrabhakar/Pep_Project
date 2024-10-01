package com.ponsun.pep.relativeDetails.RelativesCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RelativeDetDTO {
    private Integer id;
    private Integer pepId;
    private Integer relativeId;
    private String name;
    private String pan;
    private Integer uid;
    private Integer euid;

    public RelativeDetDTO(Integer id, Integer pepId, Integer relativeId, String name, String pan, Integer uid, Integer euid) {
        this.id = id;
        this.pepId = pepId;
        this.relativeId = relativeId;
        this.name = name;
        this.pan = pan;
        this.uid = uid;
        this.euid = euid;
    }

    public static RelativeDetDTO newInstance(Integer id,Integer pepId, Integer relativeId,final String name, String pan,Integer uid,Integer euid){
        return new RelativeDetDTO(id,pepId, relativeId, name, pan,uid,euid);
    }
}
