package com.ponsun.pep.relativeDetails.Relativedet.request;

import lombok.Data;

@Data
public class AbstractRelativeDetRequest {
    private String name;
    private String pan;
    private Integer pepId;
    private Integer relativeId;
    private Integer uid;
    private Integer euid;

}
