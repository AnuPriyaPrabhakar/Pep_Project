package com.ponsun.pep.taskReassign.services;

import com.ponsun.pep.taskReassign.request.CreateTaskReassignRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface TaskReassignWritePlatformService {

   Response createTaskReassign(CreateTaskReassignRequest createTaskReassignRequest);
    Response createTaskAssign(Integer pepId,Integer uid);
    Response updateEntry(Integer pepId, Integer uid, String statusCall);
    // Response updateTaskReassign(Integer id, UpdateTaskReassignRequest updateTaskReassignRequest);

    Response blockTaskReassign(Integer id);

    Response unblockTaskReassign(Integer id);
}
