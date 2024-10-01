package com.ponsun.pep.reports.ManagerPendingDt.data;

import lombok.Data;

@Data
public class ManagerPendingDtData {

    private Integer count;
    private String frmDate;
    private String toDate;

    public  ManagerPendingDtData (final Integer count , final String frmDate , final String toDate){
        this.count = count;
        this.frmDate = frmDate;
        this.toDate = toDate;
    }
    public static ManagerPendingDtData newInstance (final Integer count , final String frmDate , final String toDate){
        return new ManagerPendingDtData(count ,frmDate ,  toDate);
    }
}
