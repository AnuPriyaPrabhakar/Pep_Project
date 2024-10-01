package com.ponsun.pep.taskReassign.services;
import com.ponsun.pep.taskReassign.domain.TaskReassign;

import java.util.List;

public interface TaskReassignReadPlatformService {

    List<TaskReassign> fetchAllTaskReassign();

    TaskReassign fetchTaskReassignById(Integer id);

    TaskReassign fetchTaskReassignByPepId(Integer pepId);

}
