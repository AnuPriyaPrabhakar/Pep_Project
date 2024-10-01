
package com.ponsun.pep.Edit.QcPending.data;

import lombok.Data;

@Data
public class QcPendingData {
    private String pepName;
    private String pepPan;
    private String pepDOB;
    private String pepSourceLink;
    private String fromDate;
    private String toDate;



    public  QcPendingData (final String pepName , final String  pepPan , final String pepDOB , final String pepSourceLink , final String fromDate , final String toDate){
        this.pepName = pepName;
        this.pepPan = pepPan;
        this.pepDOB = pepDOB;
        this.pepSourceLink = pepSourceLink;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public static QcPendingData newInstance (final String pepName , final String  pepPan , final String pepDOB , final String pepSourceLink , final String fromDate , final String toDate){
        return new QcPendingData(pepName , pepPan ,pepDOB ,  pepSourceLink,fromDate,toDate);
    }
}

