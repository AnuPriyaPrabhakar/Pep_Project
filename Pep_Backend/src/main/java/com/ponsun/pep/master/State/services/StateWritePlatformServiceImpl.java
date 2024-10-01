package com.ponsun.pep.master.State.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.State.data.StateDataValidator;
import com.ponsun.pep.master.State.domain.State;
import com.ponsun.pep.master.State.domain.StateRepository;
import com.ponsun.pep.master.State.domain.StateRepositoryWrapper;
import com.ponsun.pep.master.State.request.CreateStateRequest;
import com.ponsun.pep.master.State.request.UpdateStateRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StateWritePlatformServiceImpl implements StateWritePlatformService{
    private final StateRepository stateRepository;
    private final StateRepositoryWrapper stateRepositoryWrapper;
    private final StateDataValidator stateDataValidator;

    @Transactional
    public Response createState(CreateStateRequest createStateRequest){
        try{
            this.stateDataValidator.validatesaveStateData(createStateRequest);
            final State state = State.create(createStateRequest);
            this.stateRepository.saveAndFlush(state);
            return Response.of(Long.valueOf(state.getId()));
        }catch(DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateState(Integer id, UpdateStateRequest updateStateRequest){
        try{
            this.stateDataValidator.validateUpdateStateData(updateStateRequest);
            final  State state = this.stateRepositoryWrapper.findOneWithNotFoundDetection(id);
           state.update(updateStateRequest);
           this.stateRepository.saveAndFlush(state);
            return Response.of(Long.valueOf(state.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockState(Integer id){
        try{
            final State state = this.stateRepositoryWrapper.findOneWithNotFoundDetection(id);
            state.setStatus(Status.DELETE);
            state.setUpdatedAt(LocalDateTime.now());
           this.stateRepository.saveAndFlush(state);
           return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
          throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockState(Integer id){
        try{
            final State state = this.stateRepositoryWrapper.findOneWithNotFoundDetection(id);
            state.setStatus(Status.ACTIVE);
            state.setUpdatedAt(LocalDateTime.now());
            this.stateRepository.saveAndFlush(state);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
