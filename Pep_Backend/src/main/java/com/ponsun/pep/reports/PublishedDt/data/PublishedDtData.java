package com.ponsun.pep.reports.PublishedDt.data;
import lombok.Data;

@Data
public class PublishedDtData {
    private Integer count;
    private String frmDate;
    private String toDate;

    public  PublishedDtData (final Integer count , final String frmDate , final String toDate){
        this.count = count;
        this.frmDate = frmDate;
        this.toDate = toDate;
    }
    public static PublishedDtData newInstance (final Integer count , final String frmDate , final String toDate){
        return new PublishedDtData(count ,frmDate ,  toDate);
    }
}
