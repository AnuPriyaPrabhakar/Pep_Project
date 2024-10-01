package com.ponsun.pep.master.State.domain;

import com.ponsun.pep.master.State.request.AbstractStateRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StateRepositoryWrapper extends AbstractStateRequest {
    private final StateRepository stateRepository;
    @Transactional
    public State findOneWithNotFoundDetection(final Integer id){
        return this.stateRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("State Not found "+ id));
    }
    @Override
    public String toString(){ return super.toString();}
}
