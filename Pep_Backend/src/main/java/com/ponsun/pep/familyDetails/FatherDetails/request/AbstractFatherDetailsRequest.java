package com.ponsun.pep.familyDetails.FatherDetails.request;

import lombok.Data;

@Data
public class AbstractFatherDetailsRequest {
    private Integer pepId;
    private String fatherName;
    private String fatherPan;
    private Integer hufId;
    private Integer uid;
    private Integer euid;
}
