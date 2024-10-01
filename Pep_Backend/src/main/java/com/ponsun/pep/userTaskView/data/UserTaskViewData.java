package com.ponsun.pep.userTaskView.data;

import lombok.Data;

@Data
public class UserTaskViewData {
    private String countryName;
    private String stateName;
    private Integer YEAR;
    private String manName;
    private Integer taskId;
    private Integer countryId;
    private Integer stateId;
    private Integer assignById;
    private Integer assignTo;

    public UserTaskViewData(final String countryName, final String stateName, final Integer YEAR, final String manName, final Integer taskId, final Integer countryId, final Integer stateId, final Integer assignById, final Integer assignTo){
        this.countryName = countryName;
        this.stateName = stateName;
        this.YEAR = YEAR;
        this.manName = manName;
        this.taskId = taskId;
        this.countryId = countryId;
        this.stateId = stateId;
        this.assignById = assignById;
        this.assignTo = assignTo;
    }

    public static UserTaskViewData newInstance(final String countryName, final String stateName, final Integer YEAR, final String manName, final Integer taskId, final Integer countryId, final Integer stateId, final Integer assignById, final Integer assignTo){
        return new UserTaskViewData(countryName , stateName ,YEAR ,  manName ,taskId , countryId ,stateId,assignById ,assignTo);
    }
}
