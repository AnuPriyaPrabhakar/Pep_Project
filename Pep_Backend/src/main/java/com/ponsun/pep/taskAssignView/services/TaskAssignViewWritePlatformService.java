package com.ponsun.pep.taskAssignView.services;

import com.ponsun.pep.taskAssignView.data.TaskAssignViewData;

import java.util.List;

public interface TaskAssignViewWritePlatformService {
    List<TaskAssignViewData> fetchAllTaskAssignViewData();
}
