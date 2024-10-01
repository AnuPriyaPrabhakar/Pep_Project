package com.ponsun.pep.reports.TaskAssignReport.data;

import lombok.Data;

@Data
public class TaskAssignReportData {
    private String country;
    private String state;
    private String year;
    private String uid;
    private String frmDate;
    private String  toDate;

    public TaskAssignReportData(final String country,final String state,final String year,final String uid,final String frmDate,final String toDate){
        this.country = country;
        this.state = state;
        this.year = year;
        this.uid = uid;
        this.frmDate = frmDate;
        this.toDate = toDate;
    }
    public static  TaskAssignReportData newInstance(final String country,final String state,final String year,final String uid,final String frmDate,final String toDate){
        return new TaskAssignReportData(country,state,year,uid,frmDate,toDate);
    }

}
