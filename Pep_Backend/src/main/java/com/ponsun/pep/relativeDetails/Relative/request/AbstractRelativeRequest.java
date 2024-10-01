package com.ponsun.pep.relativeDetails.Relative.request;

import lombok.Data;

@Data
public class AbstractRelativeRequest {
    private Integer id;
    private Integer pepId;
    private Integer relativeMasterId;
    private String relativeName;
    private String pan;
    private Integer uid;
    private Integer euid;
}
