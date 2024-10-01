package com.ponsun.pep.taskAssign.domain;

import com.ponsun.pep.taskAssign.request.AbstractTaskAssignBaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskAssignRepositoryWrapper extends AbstractTaskAssignBaseRequest {
    private final TaskAssignRepository taskAssignRepository;

    @Transactional
    public TaskAssign findOneWithNotFoundDetection(final Integer id){
        return this.taskAssignRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("TaskAssign Not found " + id));
    }
    @Override
    public String toString(){ return super.toString();}
}
