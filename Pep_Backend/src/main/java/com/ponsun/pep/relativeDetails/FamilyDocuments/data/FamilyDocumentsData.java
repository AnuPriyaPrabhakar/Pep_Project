package com.ponsun.pep.relativeDetails.FamilyDocuments.data;

import lombok.Data;

@Data
public class FamilyDocumentsData {
    private String documentType;
    private Integer pepId;
    private Integer pathId;
    private Integer relativeMasterId;
    private Integer documentCount;
    private String documentNameList;
    private Integer uid;
    private Integer euid;

    public FamilyDocumentsData(final String documentType, final Integer pepId, final Integer pathId, final Integer relativeMasterId, final Integer documentCount, final String documentNameList, final Integer uid, final Integer euid) {

        this.documentType = documentType;
        this.pepId = pepId;
        this.pathId = pathId;
        this.relativeMasterId = relativeMasterId;
        this.documentCount = documentCount;
        this.documentNameList = documentNameList;
        this.uid = uid;
        this.euid = euid;

    }

    public static FamilyDocumentsData newInstance(final String documentType, final Integer pepId,final Integer pathId, final Integer relativeMasterId, final Integer documentCount, final String documentNameList, final Integer uid, final Integer euid) {
        return new FamilyDocumentsData(documentType, pepId,pathId, relativeMasterId, documentCount, documentNameList, uid, euid);
    }
}
