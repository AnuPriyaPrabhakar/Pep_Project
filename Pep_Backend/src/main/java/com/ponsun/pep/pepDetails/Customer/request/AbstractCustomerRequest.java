package com.ponsun.pep.pepDetails.Customer.request;

import lombok.Data;

@Data
public class AbstractCustomerRequest {
    private Integer id;
    private String name;
    private String sourceLink;
//        private String gender;
    private Integer genderId;
    private String placeOfBirth;
    private String education;
    private String dob;
    private String pan;
    private String directorsIdentificationNumber;
    private Integer adverseInformation;
    private Integer regulatoryAction;
    private Integer uid;
    private Integer euid;
    private String qcViewDt;
    private String qcEditDt;
    private String managerApproveDt;
    private String qcPendingDt;
    private String publishedDt;
    private String managerPendingDt;
}
