package com.ponsun.pep.master.Country.request;

import lombok.Data;

@Data
public class AbstractCountryRequest {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;
}
