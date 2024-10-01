package com.ponsun.pep.relativeDetails.RelativeChildrenDet.request;

import lombok.Data;

@Data
public class AbstractChildrenDetRequest {
    private Integer pepId;
    private Integer relativeId;
    private Integer relativeDetId;
    private String childrenName;
    private String pan;
    private Integer uid;
    private Integer euid;


}
