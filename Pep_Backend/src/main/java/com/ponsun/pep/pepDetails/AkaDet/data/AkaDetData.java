package com.ponsun.pep.pepDetails.AkaDet.data;

import lombok.Data;

@Data
public class AkaDetData {
    private Integer id;
    private Integer pepId;
    private String akaName;
    private Integer uid;
    private Integer euid;

    public AkaDetData(final Integer id,final Integer pepId, final String akaName,final Integer uid,final Integer euid) {
        this.id = id;
        this.pepId = pepId;
        this.akaName =akaName;
        this.uid = uid;
        this.euid = euid;

    }

    public static AkaDetData newInstance(final Integer id,final Integer pepId, final String akaName,final Integer uid,final Integer euid){
        return new AkaDetData(id,pepId,akaName,uid,euid);
    }
}
