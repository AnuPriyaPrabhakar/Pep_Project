package com.ponsun.pep.master.State.request;

import lombok.Data;

@Data
public class AbstractStateRequest {
    private Integer id;
    private Integer countryId;
    private String stateName;
    private Integer uid;
    private Integer euid;
}
