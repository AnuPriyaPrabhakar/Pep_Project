package com.ponsun.pep.master.District.request;

import lombok.Data;

@Data
public class AbstractDistrictRequest {

    private String cityName;
    private Integer stateId;
    private Integer countryId;
    private  Integer uid;
    private Integer euid;
}
