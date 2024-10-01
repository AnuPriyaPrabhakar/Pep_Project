package com.ponsun.pep.searchLifcycle.PendingCase.data;

import lombok.Data;

@Data
public class PendingCaseData {
    private Integer caseId;
    private Integer criminalId;
    private Integer hitId;
    private Integer levelId;
    private Integer searchId;
    private Integer statusId;
    private Integer uid;
    private String criminalName;
    private Integer matchingScore;
    private String remark;
    private String searchName;
    public PendingCaseData(final Integer caseId, final Integer criminalId,
                           final Integer hitId, final Integer levelId,
                           final Integer searchId, final Integer statusId,final Integer uid,final String criminalName,
                           final Integer matchingScore, final String remark , final String searchName) {
        this.caseId = caseId;
        this.criminalId = criminalId;
        this.hitId = hitId;
        this.levelId = levelId;
        this.searchId = searchId;
        this.statusId = statusId;
        this.uid=uid;
        this.criminalName = criminalName;
        this.matchingScore = matchingScore;
        this.remark = remark;
        this.searchName = searchName;
    }

    public static PendingCaseData newInstance(final Integer caseId, final Integer criminalId,
                                              final Integer hitId, final Integer levelId,
                                              final Integer searchId, final Integer statusId,final Integer uid,
                                              final String criminalName,
                                              final Integer matchingScore, final String remark , final String searchName) {
        return new PendingCaseData(caseId, criminalId, hitId, levelId,searchId,statusId,uid,criminalName,matchingScore, remark , searchName);
    }

}
