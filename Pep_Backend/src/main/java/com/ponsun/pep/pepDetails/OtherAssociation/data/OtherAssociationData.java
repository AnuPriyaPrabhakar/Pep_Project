package com.ponsun.pep.pepDetails.OtherAssociation.data;

import lombok.Data;

@Data
public class OtherAssociationData {
    private Integer id;
    private Integer pepId;
    private String otherAssociationAsPerMedia;
    private Integer uid;
    private Integer euid;

    public OtherAssociationData(final Integer id,final Integer pepId,final String otherAssociationAsPerMedia,final Integer uid,final Integer euid){
        this.id = id;
        this.pepId = pepId;
        this.otherAssociationAsPerMedia = otherAssociationAsPerMedia;
        this.uid = uid;
        this.euid = euid;
    }
    public static OtherAssociationData newInstance(final Integer id,final Integer pepId,final String otherAssociationAsPerMedia,final Integer uid,final Integer euid){
        return new OtherAssociationData(id,pepId,otherAssociationAsPerMedia,uid,euid);
    }
}
