package com.ponsun.pep.taskAssign.services;

import com.ponsun.pep.taskAssign.data.TaskAssignDataValidator;
import com.ponsun.pep.taskAssign.domain.TaskAssign;
import com.ponsun.pep.taskAssign.domain.TaskAssignRepository;
import com.ponsun.pep.taskAssign.domain.TaskAssignRepositoryWrapper;
import com.ponsun.pep.taskAssign.request.CreateTaskAssignRequest;
import com.ponsun.pep.taskAssign.request.UpdateTaskAssignRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskAssignWritePlatformServiceImpl implements TaskAssignWritePlatformService{
    private final TaskAssignRepository taskAssignRepository;
    private final TaskAssignRepositoryWrapper taskAssignRepositoryWrapper;
    private final TaskAssignDataValidator taskAssignDataValidator;

    @Transactional
    public Response createTaskAssign(CreateTaskAssignRequest createTaskAssignRequest){
        try{
            this.taskAssignDataValidator.validateSaveTaskAssign(createTaskAssignRequest);
            final TaskAssign taskAssign = TaskAssign.create(createTaskAssignRequest);
            this.taskAssignRepository.saveAndFlush(taskAssign);
            return Response.of(Long.valueOf(taskAssign.getId()));
        }catch (DataIntegrityViolationException e){
            log.error("Error creating TaskAssign: {}",e.getMessage(),e);
            throw new EQAS_PEP_AppicationException("Error creating TaskAssign:"+e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateTaskAssign(Integer id, UpdateTaskAssignRequest updateTaskAssignRequest){
        try{
            this.taskAssignDataValidator.validateUpdateTaskAssign(updateTaskAssignRequest);
            final TaskAssign taskAssign = this.taskAssignRepositoryWrapper.findOneWithNotFoundDetection(id);
            taskAssign.update(updateTaskAssignRequest);
            this.taskAssignRepository.saveAndFlush(taskAssign);
            return Response.of(Long.valueOf(taskAssign.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response deactive(Integer id,Integer euid) {
        try {
            TaskAssign taskAssign = this.taskAssignRepositoryWrapper.findOneWithNotFoundDetection(id);
            taskAssign.setEuid(euid);
            taskAssign.setStatus(Status.ACTIVE);
            taskAssign.setUpdatedAt(LocalDateTime.now());
            return Response.of(Long.valueOf(taskAssign.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
//    @Override
//    @Transactional
//    public Response blockTaskAssign(Integer id){
//        try{
//            final TaskAssign taskAssign = this.taskAssignRepositoryWrapper.findOneWithNotFoundDetection(id);
//            taskAssign.setValid(false);
//            taskAssign.setStatus(Status.ACTIVE);
//            taskAssign.setUpdatedAt(LocalDateTime.now());
//            this.taskAssignRepository.saveAndFlush(taskAssign);
//            return Response.of(Long.valueOf(id));
//        }catch (DataIntegrityViolationException e){
//            throw new EQAS_PEP_AppicationException(e.getMessage());
//        }
//    }
//    @Override
//    @Transactional
//    public Response unblockTaskAssign(Integer id){
//        try{
//            final TaskAssign taskAssign = this.taskAssignRepositoryWrapper.findOneWithNotFoundDetection(id);
//            taskAssign.setValid(true);
//            taskAssign.setStatus(Status.ACTIVE);
//            taskAssign.setUpdatedAt(LocalDateTime.now());
//            this.taskAssignRepository.saveAndFlush(taskAssign);
//            return Response.of(Long.valueOf(id));
//        }catch (DataIntegrityViolationException e){
//            throw new EQAS_PEP_AppicationException(e.getMessage());
//        }
//    }

}
