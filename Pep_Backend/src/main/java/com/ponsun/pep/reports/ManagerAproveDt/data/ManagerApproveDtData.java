package com.ponsun.pep.reports.ManagerAproveDt.data;
import lombok.Data;

@Data
public class ManagerApproveDtData {
    private String name;
    private Integer count;
    private String frmDate;
    private String toDate;

    public  ManagerApproveDtData (final String name , final Integer count , final String frmDate , final String toDate){
        this.name = name;
        this.count = count;
        this.frmDate = frmDate;
        this.toDate = toDate;
    }
    public static ManagerApproveDtData newInstance (final String name , final Integer count , final String frmDate , final String toDate){
        return new ManagerApproveDtData(name , count ,frmDate ,  toDate);
    }
}
