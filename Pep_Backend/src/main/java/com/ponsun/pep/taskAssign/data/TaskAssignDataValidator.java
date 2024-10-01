package com.ponsun.pep.taskAssign.data;

import com.ponsun.pep.taskAssign.request.CreateTaskAssignRequest;
import com.ponsun.pep.taskAssign.request.UpdateTaskAssignRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskAssignDataValidator {
    public void validateSaveTaskAssign(final CreateTaskAssignRequest request){
        if(request.getAssignTo() == null || request.getAssignTo().equals("")){
            throw  new EQAS_PEP_AppicationException("TaskAssignTo parameter required");
        }
        if(request.getAssignBy() == null || request.getAssignBy().equals("")){
            throw new EQAS_PEP_AppicationException("TaskAssignBy parameter required");
        }
    }

    public void validateUpdateTaskAssign(final UpdateTaskAssignRequest request){
        if(request.getAssignTo() == null || request.getAssignTo().equals("")){
            throw new EQAS_PEP_AppicationException("TaskAssignTo parameter required");
        }
        if(request.getAssignBy() == null || request.getAssignBy().equals("")){
            throw new EQAS_PEP_AppicationException("TaskAssignBy parameter required");
        }
    }
}
