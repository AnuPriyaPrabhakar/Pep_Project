package com.ponsun.pep.userTaskView.services;


import com.ponsun.pep.userTaskView.data.UserTaskViewData;


import java.util.List;

public interface UserTaskViewWritePlatformService {

    List<UserTaskViewData> fetchAllFirstPageData(Integer assignTo);
}
