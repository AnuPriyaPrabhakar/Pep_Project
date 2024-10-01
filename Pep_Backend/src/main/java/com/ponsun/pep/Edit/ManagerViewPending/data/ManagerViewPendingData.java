package com.ponsun.pep.Edit.ManagerViewPending.data;

import lombok.Data;

@Data
public class ManagerViewPendingData {
    private String pepName;
    private String panNum;
    private String dob;
    private String sourceLink;
    private String fromDate;
    private String toDate;



    public ManagerViewPendingData(final String pepName , final String panNum , final String dob , final String sourceLink , final String fromDate , final String toDate){
        this.pepName = pepName;
        this.panNum = panNum;
        this.dob = dob;
        this.sourceLink = sourceLink;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public static ManagerViewPendingData newInstance (final String pepName , final String panNum , final String dob , final String sourceLink , final String fromDate , final String toDate) {
        return new ManagerViewPendingData(pepName , panNum ,dob ,sourceLink ,fromDate,toDate);
    }
}
