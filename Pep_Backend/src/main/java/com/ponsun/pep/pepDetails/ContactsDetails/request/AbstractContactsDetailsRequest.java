package com.ponsun.pep.pepDetails.ContactsDetails.request;

import lombok.Data;

@Data
public class AbstractContactsDetailsRequest {
    private Integer id;
    private Integer pepId;
    private String communicationDt;
    private Integer communicationTypeId;
    private Integer uid;
    private Integer euid;
}
