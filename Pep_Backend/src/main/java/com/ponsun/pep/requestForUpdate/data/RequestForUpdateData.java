package com.ponsun.pep.requestForUpdate.data;

import lombok.Data;

@Data
public class RequestForUpdateData {
    private Integer pepId;
    private String requestAt;
    private Integer requestUid;
    private Integer updatedUid;
    private Integer valid;
    private String updated;
    private String requestForUpdate;


    public RequestForUpdateData (final Integer pepId , final String requestAt , final Integer requestUid , final Integer updatedUid , final Integer valid , final String updated ,final String requestForUpdate) {
        this.pepId =  pepId;
        this.requestAt = requestAt;
        this.requestUid = requestUid;
        this.updatedUid = updatedUid;
        this.valid = valid;
        this.updated = updated;
        this.requestForUpdate = requestForUpdate;
    }

    public static RequestForUpdateData newInstance (final Integer pepId , final String requestAt , final Integer requestUid , final Integer updatedUid , final Integer valid , final String updated ,final String requestForUpdate) {
        return new RequestForUpdateData (pepId,requestAt,requestUid,updatedUid,valid,updated,requestForUpdate);
    }
}
