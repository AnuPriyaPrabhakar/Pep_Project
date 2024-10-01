package com.ponsun.pep.relativeDetails.Relativedet.data;

import lombok.Data;

@Data
public class RelativeDetData {
    private Integer id;
    private String name;
    private String pan;
    private Integer pepId;
    private Integer relativeId;
    private Integer uid;
    private Integer euid;

    public RelativeDetData(final Integer id, final String name, final String pan,final Integer pepId, final Integer relativeId,final Integer uid,final Integer euid){
        this.id = id;
        this.name = name;
        this.pan = pan;
        this.pepId = pepId;
        this.relativeId = relativeId;
        this.uid = uid;
        this.euid = euid;
    }

    public static RelativeDetData newInstance(final Integer id, final String name, final String pan,final Integer pepId, final Integer relativeId,final Integer uid,final  Integer euid){
        return new RelativeDetData(id,name,pan,pepId,relativeId,uid,euid);
    }
}
