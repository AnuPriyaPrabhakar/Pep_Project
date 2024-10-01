package com.ponsun.pep.taskAssign.services;

import com.ponsun.pep.taskAssign.domain.TaskAssign;
import java.util.List;
public interface TaskAssignReadPlatformService {
    TaskAssign fetchTaskAssignById(Integer id);
    List<TaskAssign> fetchAllTaskAssign();
}
