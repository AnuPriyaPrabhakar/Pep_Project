package com.ponsun.pep.master.gender.request;

import lombok.Data;

@Data
public abstract class AbstractGenderBaseRequest {

    private Integer id;
    private String gender;
    private Boolean valid;

}
