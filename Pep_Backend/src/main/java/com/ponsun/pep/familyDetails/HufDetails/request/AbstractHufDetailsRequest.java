package com.ponsun.pep.familyDetails.HufDetails.request;

import lombok.Data;

@Data
public class AbstractHufDetailsRequest {
    private Integer pepId;
    private String hufName;
    private String hufPan;
    private Integer uid;
    private Integer euid;
}
