package com.ponsun.pep.reports.QcViewDt.data;

import lombok.Data;

@Data
public class QcViewDtData {
    private String name;
    private Integer count;
    private String frmDate;
    private String toDate;

    public  QcViewDtData (final String name , final Integer count , final String frmDate , final String toDate){
        this.name = name;
        this.count = count;
        this.frmDate = frmDate;
        this.toDate = toDate;
    }
    public static QcViewDtData newInstance (final String name , final Integer count , final String frmDate , final String toDate){
        return new QcViewDtData(name , count ,frmDate ,  toDate);
    }
}
