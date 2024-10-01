package com.ponsun.pep.taskAssign.services;

import com.ponsun.pep.taskAssign.request.CreateTaskAssignRequest;
import com.ponsun.pep.taskAssign.request.UpdateTaskAssignRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface TaskAssignWritePlatformService {
    Response createTaskAssign(CreateTaskAssignRequest createTaskAssignRequest);
    Response updateTaskAssign(Integer id, UpdateTaskAssignRequest updateTaskAssignRequest);
    Response deactive(Integer id,Integer euid);
//    Response blockTaskAssign(Integer id);
//    Response unblockTaskAssign(Integer id);
}
