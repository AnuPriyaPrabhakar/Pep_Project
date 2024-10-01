package com.ponsun.pep.relativeDetails.RelativeChildrenDet.data;
import lombok.Data;

@Data
public class ChildrenDetData {
    private Integer pepId;
    private Integer relativeId;
    private Integer relativeDetId;
    private String childrenName;
    private String pan;
    private Integer uid;
    private  Integer euid;
    public ChildrenDetData (final Integer pepId ,final Integer relativeId , final Integer relativeDetId , final String childrenName , final String pan,final Integer uid,final Integer euid ) {
        this.pepId = pepId;
        this.relativeId = relativeId;
        this.relativeDetId = relativeDetId;
        this.childrenName = childrenName;
        this.pan = pan;
        this.uid = uid;
        this.euid = euid;
    }
    public static ChildrenDetData newInstance (final Integer pepId , final Integer relativeId,final Integer relativeDetId , final String childrenName , final String pan,final Integer uid,final Integer euid ) {
        return new ChildrenDetData(pepId,relativeId,relativeDetId,childrenName,pan,uid,euid);
    }
}
