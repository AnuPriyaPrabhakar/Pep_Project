package com.ponsun.pep.reports.QcPendingDt.data;

import lombok.Data;

@Data

public class QcPendingDtData {
    private Integer count;
    private String frmDate;
    private String toDate;

    public  QcPendingDtData ( final Integer count , final String frmDate , final String toDate){
        this.count = count;
        this.frmDate = frmDate;
        this.toDate = toDate;
    }
    public static QcPendingDtData newInstance ( final Integer count , final String frmDate , final String toDate){
        return new QcPendingDtData(count ,frmDate ,  toDate);
    }
}
