package com.ponsun.pep.taskAssignView.data;

import lombok.Data;

@Data
public class TaskAssignViewData {
    private String country;
    private String state;
    private String year;
    private String uid;

    public TaskAssignViewData(final String country,final String state,final String year,final String uid){
        this.country = country;
        this.state = state;
        this.year = year;
        this.uid = uid;
    }
    public static TaskAssignViewData newInstance(final String country,final String state,final String year,final String uid){
        return new TaskAssignViewData(country,state,year,uid);
    }
}
