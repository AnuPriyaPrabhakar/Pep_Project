package com.ponsun.pep.taskAssign.request;

import lombok.Data;

@Data
public class AbstractTaskAssignBaseRequest {
    private  Integer assignTo;
    private Integer assignBy;
    private Integer countryId;
    private Integer stateId;
    private Integer year;
    private Integer uid;
//    private Integer euid;
}
