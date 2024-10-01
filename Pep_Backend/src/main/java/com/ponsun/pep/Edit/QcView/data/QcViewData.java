package com.ponsun.pep.Edit.QcView.data;

import lombok.Data;

@Data
public class QcViewData {
    private String pepName;
    private String pepPan;
    private String pepDOB;
    private String pepSourceLink;
    private String fromDate;
    private String toDate;



    public  QcViewData (final String pepName , final String  pepPan , final String pepDOB , final String pepSourceLink , final String fromDate , final String toDate){
        this.pepName = pepName;
        this.pepPan = pepPan;
        this.pepDOB = pepDOB;
        this.pepSourceLink = pepSourceLink;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public static QcViewData newInstance (final String pepName , final String  pepPan , final String pepDOB , final String pepSourceLink , final String fromDate , final String toDate){
        return new QcViewData(pepName , pepPan ,pepDOB ,  pepSourceLink,fromDate,toDate);
    }
}

