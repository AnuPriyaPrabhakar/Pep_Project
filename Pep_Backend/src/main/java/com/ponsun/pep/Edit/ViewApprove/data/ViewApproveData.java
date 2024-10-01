package com.ponsun.pep.Edit.ViewApprove.data;

import com.ponsun.pep.Edit.QcView.data.QcViewData;
import lombok.Data;

@Data
public class ViewApproveData {
    private String pepName;
    private String pepPan;
    private String pepDOB;
    private String pepSourceLink;
    private String fromDate;
    private String toDate;



    public  ViewApproveData (final String pepName , final String  pepPan , final String pepDOB , final String pepSourceLink , final String fromDate , final String toDate){
        this.pepName = pepName;
        this.pepPan = pepPan;
        this.pepDOB = pepDOB;
        this.pepSourceLink = pepSourceLink;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public static ViewApproveData newInstance (final String pepName , final String  pepPan , final String pepDOB , final String pepSourceLink , final String fromDate , final String toDate){
        return new ViewApproveData(pepName , pepPan ,pepDOB , pepSourceLink,fromDate,toDate);
    }
}
