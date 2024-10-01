package com.ponsun.pep.listOfCompany.request;

import lombok.Data;

@Data
public class AbstractListOfCompanyRequest {
    private Integer id;
    private String type;
    private Integer uid;
    private Integer euid;
}
