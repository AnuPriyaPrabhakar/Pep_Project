package com.ponsun.pep.Edit.ManagerPending.data;
import lombok.Data;

@Data
public class QcManagerPendingData {

    private String pepName;
    private String panNum;
    private String dob;
    private String sourceLink;
    private String fromDate;
    private String toDate;
    private String pepId;
    public  QcManagerPendingData (final String pepName , final String  panNum , final String dob , final String sourceLink , final String fromDate , final String toDate,final  String pepId){
        this.pepName = pepName;
        this.panNum = panNum;
        this.dob = dob;
        this.sourceLink = sourceLink;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.pepId = pepId;
    }
    public static QcManagerPendingData newInstance (final String pepName , final String  panNum , final String dob , final String sourceLink , final String fromDate , final String toDate,final  String pepId){
        return new QcManagerPendingData(pepName , panNum ,dob , sourceLink,fromDate,toDate,pepId);
    }
}

