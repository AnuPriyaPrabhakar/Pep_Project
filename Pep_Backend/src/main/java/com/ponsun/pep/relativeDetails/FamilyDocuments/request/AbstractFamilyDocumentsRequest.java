package com.ponsun.pep.relativeDetails.FamilyDocuments.request;

import lombok.Data;

@Data
public class AbstractFamilyDocumentsRequest {
    private String documentType;
    private Integer pepId;
    private Integer pathId;
    private Integer relativeMasterId;
    private Integer documentCount;
    private String documentNameList;
    private Integer uid;
    private Integer euid;

}
