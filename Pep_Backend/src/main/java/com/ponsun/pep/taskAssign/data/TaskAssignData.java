package com.ponsun.pep.taskAssign.data;

import lombok.Data;

@Data
public class TaskAssignData {
    private  Integer assignTo;
    private Integer assignBy;
    private Integer countryId;
    private Integer stateId;
    private Integer year;
    private Integer uid;

    public TaskAssignData(final Integer assignTo,final Integer assignBy,final Integer countryId,final Integer stateId,final Integer year,final Integer uid){
        this.assignTo = assignTo;
        this.assignBy = assignBy;
        this.countryId = countryId;
        this.stateId = stateId;
        this.year = year;
        this.uid = uid;
    }
    public static  TaskAssignData newInstance(final Integer assignTo,final Integer assignBy,final Integer countryId,final Integer stateId,final Integer year,final Integer uid){
        return new TaskAssignData(assignTo,assignBy,countryId,stateId,year,uid);
    }
}
