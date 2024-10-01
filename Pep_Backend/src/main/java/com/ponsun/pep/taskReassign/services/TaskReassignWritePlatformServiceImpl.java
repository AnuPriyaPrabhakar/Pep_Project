package com.ponsun.pep.taskReassign.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.taskReassign.data.TaskReassignDataValidator;
import com.ponsun.pep.taskReassign.domain.TaskReassign;
import com.ponsun.pep.taskReassign.domain.TaskReassignRepository;
import com.ponsun.pep.taskReassign.domain.TaskReassignRepositoryWrapper;
import com.ponsun.pep.taskReassign.request.CreateTaskReassignRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskReassignWritePlatformServiceImpl implements TaskReassignWritePlatformService {

    private final TaskReassignRepository taskReassignRepository;
    private final TaskReassignRepositoryWrapper taskReassignRepositoryWrapper;
    private final TaskReassignDataValidator taskReassignDataValidator;

    @Override
    @Transactional
    public Response createTaskReassign(CreateTaskReassignRequest createTaskReassignRequest) {
        try {
            this.taskReassignDataValidator.validateSaveTaskReassign(createTaskReassignRequest);
            final TaskReassign taskReassign = TaskReassign.create(createTaskReassignRequest);//entity
            this.taskReassignRepository.saveAndFlush(taskReassign);
            return Response.of(Long.valueOf(taskReassign.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response createTaskAssign(Integer pepId,Integer uid) {
        try {
            final TaskReassign taskReassign = TaskReassign.createtask(pepId, uid);//entity
            this.taskReassignRepository.saveAndFlush(taskReassign);
            return Response.of(Long.valueOf(taskReassign.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockTaskReassign(Integer id) {
        try {
            final TaskReassign taskReassign = this.taskReassignRepositoryWrapper.findOnePepIdWithNotFoundDetection(id);
            taskReassign.setStatus(Status.DELETE); // Or set the appropriate status
            taskReassign.setUpdatedAt(LocalDateTime.now());
            this.taskReassignRepository.saveAndFlush(taskReassign);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockTaskReassign(Integer id) {
        try {
            final TaskReassign taskReassign = this.taskReassignRepositoryWrapper.findOnePepIdWithNotFoundDetection(id);
            taskReassign.setStatus(Status.ACTIVE); // Or set the appropriate status
            taskReassign.setUpdatedAt(LocalDateTime.now());
            this.taskReassignRepository.saveAndFlush(taskReassign);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateEntry(Integer pepId,Integer uid,String statusCall){
        try {
            final TaskReassign taskReassign = this.taskReassignRepositoryWrapper.findOnePepIdWithNotFoundDetection(pepId);
            if(statusCall.equals("DataEntry")) {

                taskReassign.setEntryUid(uid);
                taskReassign.setEntryDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }
            if(statusCall.equals("QcView")) {
                taskReassign.setQcView(1);
                taskReassign.setQcApproved(0);
                taskReassign.setQcViewUid(uid);
                taskReassign.setQcViewDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }

            if(statusCall.equals("QcEdit")) {
                taskReassign.setQcEdit(1);
                taskReassign.setQcEditUid(uid);
                taskReassign.setQcEditDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }
            if(statusCall.equals("ManagerView")) {
                taskReassign.setManagerView(1);
                taskReassign.setQcApproved(1);
                taskReassign.setManagerApprove(0);
                taskReassign.setManagerPending(1);
                taskReassign.setManagerViewUid(uid);
                taskReassign.setManagerViewDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }
            if(statusCall.equals("CloseManagerView")) {
                taskReassign.setManagerView(0);
                taskReassign.setManagerViewUid(uid);
                taskReassign.setManagerViewDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }
            if(statusCall.equals("CloseView")) {
                taskReassign.setQcView(0);
                taskReassign.setManagerViewUid(uid);
                taskReassign.setManagerViewDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }
            if(statusCall.equals("ManagerApprove")) {
                taskReassign.setManagerApprove(1);
                taskReassign.setManagerView(0);
                taskReassign.setManagerApproveUid(uid);
                taskReassign.setManagerApproveDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }

            if(statusCall.equals("ManagerPending")) {
                taskReassign.setManagerApprove(1);
                taskReassign.setManagerApproveUid(uid);
                taskReassign.setManagerApproveDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }

            if(statusCall.equals("QcPending")) {
                taskReassign.setQcPending(1);
                taskReassign.setQcPendingUid(uid);
                taskReassign.setQcPendingDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }

            if(statusCall.equals("Published")) {
                taskReassign.setPublished(1);
                taskReassign.setPublishedUid(uid);
                taskReassign.setPublishedDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }
            if(statusCall.equals("ReAssign")) {
                taskReassign.setReassignToUid(1);
                taskReassign.setReassignByUid(uid);
                taskReassign.setReassignDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }
            if(statusCall.equals("QcApprove")) {
                taskReassign.setQcApproved(1);
                taskReassign.setManagerView(0);
                taskReassign.setManagerApprove(0);
                taskReassign.setQcApprovedUid(uid);
                taskReassign.setQcApprovedDt(String.valueOf(LocalDateTime.now()));
                taskReassign.onUpdate();
            }
            this.taskReassignRepository.saveAndFlush(taskReassign);
            return Response.of(Long.valueOf(pepId));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
