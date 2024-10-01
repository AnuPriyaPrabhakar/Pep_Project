package com.ponsun.pep.taskReassign.data;

import com.ponsun.pep.taskReassign.request.CreateTaskReassignRequest;
import com.ponsun.pep.taskReassign.request.UpdateTaskReassignRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskReassignDataValidator {
    public void validateSaveTaskReassign (final CreateTaskReassignRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
    }
    public void validateUpdateTaskReassign (final UpdateTaskReassignRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");


        }
    }}