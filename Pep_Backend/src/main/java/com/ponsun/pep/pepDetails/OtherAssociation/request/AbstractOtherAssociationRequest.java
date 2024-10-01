package com.ponsun.pep.pepDetails.OtherAssociation.request;

import lombok.Data;

@Data
public class AbstractOtherAssociationRequest {
    private Integer id;
    private Integer pepId;
    private String otherAssociationAsPerMedia;
    private Integer uid;
    private Integer euid;
}
