package com.ponsun.pep.relativeDetails.Relative.data;

import lombok.Data;

@Data
public class RelativeData {
    private Integer id;
    private Integer pepId;
    private Integer relativeMasterId;
    private String relativeName;
    private String pan;
    private Integer uid;
    private Integer euid;

    public RelativeData(final Integer id,final Integer pepId, final Integer relativeMasterId,final String relativeName,final String pan,final Integer uid,final Integer euid){
        this.id = id;
        this.pepId = pepId;
        this.relativeMasterId = relativeMasterId;
        this.relativeName = relativeName;
        this.pan = pan;
        this.uid = uid;
        this.euid = euid;
    }
    public static RelativeData newInstance(final Integer id,final Integer pepId, final Integer relativeMasterId,final String relativeName,final String pan,final Integer uid,final Integer euid){
        return new RelativeData(id, pepId, relativeMasterId, relativeName, pan,uid,euid);
    }
}
