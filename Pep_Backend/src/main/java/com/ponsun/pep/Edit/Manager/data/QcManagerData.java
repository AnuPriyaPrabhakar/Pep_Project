package com.ponsun.pep.Edit.Manager.data;

import lombok.Data;

@Data
public class QcManagerData {

    private String pepName;
    private String pepPan;
    private String pepDOB;
    private String pepSourceLink;
    private String fromDate;
    private String toDate;



    public  QcManagerData (final String pepName , final String  pepPan , final String pepDOB , final String pepSourceLink , final String fromDate , final String toDate){
        this.pepName = pepName;
        this.pepPan = pepPan;
        this.pepDOB = pepDOB;
        this.pepSourceLink = pepSourceLink;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public static QcManagerData newInstance (final String pepName , final String  pepPan , final String pepDOB , final String pepSourceLink , final String fromDate , final String toDate){
        return new QcManagerData(pepName , pepPan ,pepDOB ,  pepSourceLink,fromDate,toDate);
    }
}

