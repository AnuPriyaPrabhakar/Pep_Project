package com.ponsun.pep.relativeDetails.StoredProcedure.PepRelativeDet.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Data
public class PepRelativeDetData {
    private Integer pepId;
    private Integer relativeMasterId;
    private String allMemberDet;
    private Integer ipCreatedBy;
    public PepRelativeDetData(final Integer pepId,final Integer relativeMasterId,final String allMemberDet,final Integer ipCreatedBy){
        this.pepId = pepId;
        this.relativeMasterId = relativeMasterId;
        this.allMemberDet = allMemberDet;
        this.ipCreatedBy = ipCreatedBy;
    }
    public static PepRelativeDetData newInstance(final Integer pepId,final Integer relativeMasterId,final String allMemberDet,final Integer ipCreatedBy){
        return new PepRelativeDetData(pepId,relativeMasterId,allMemberDet,ipCreatedBy);
    }
}
