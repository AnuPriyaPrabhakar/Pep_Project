package com.ponsun.pep.reports.ReassignDt.data;


import lombok.Data;

@Data
public class ReassignDtData {

    private String name;
    private Integer count;
    private String frmDate;
    private String toDate;

    public  ReassignDtData (final String name , final Integer count , final String frmDate , final String toDate){
        this.name = name;
        this.count = count;
        this.frmDate = frmDate;
        this.toDate = toDate;
    }
    public static ReassignDtData newInstance (final String name , final Integer count , final String frmDate , final String toDate){
        return new ReassignDtData(name , count ,frmDate ,  toDate);
    }
}
