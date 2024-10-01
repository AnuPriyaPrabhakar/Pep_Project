package com.ponsun.pep.familyDetails.MotherDetails.request;

import lombok.Data;

@Data
public class AbstractMotherDetailsRequest {
    private Integer pepId;
    private Integer hufId;
    private String MotherName;
    private String MotherPan;
    private Integer uid;
    private Integer euid;
}
