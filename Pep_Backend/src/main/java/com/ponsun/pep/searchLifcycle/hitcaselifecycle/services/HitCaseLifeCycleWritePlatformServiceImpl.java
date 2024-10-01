package com.ponsun.pep.searchLifcycle.hitcaselifecycle.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.hitcaselifecycle.data.HitCaselifeCycleDataValidator;
import com.ponsun.pep.searchLifcycle.hitcaselifecycle.domain.HitCaseLifeCycleRepositoryWrapper;
import com.ponsun.pep.searchLifcycle.hitcaselifecycle.domain.HitcaseLifecycle;
import com.ponsun.pep.searchLifcycle.hitcaselifecycle.domain.HitcaseLifecycleRepository;
import com.ponsun.pep.searchLifcycle.hitcaselifecycle.request.CreateHitCaseLifeCycleRequest;
import com.ponsun.pep.searchLifcycle.hitcaselifecycle.request.UpdateHitCaseLifeCycleRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class HitCaseLifeCycleWritePlatformServiceImpl implements HitCaseLifeCycleWritePlatformService {

    private final HitcaseLifecycleRepository hitcaseLifecycleRepository;
    private final HitCaseLifeCycleRepositoryWrapper hitCaseLifeCycleRepositoryWrapper;
    private final HitCaselifeCycleDataValidator hitCaselifeCycleDataValidator;

    @Override
    @Transactional
    public Response createHitCaseLifeCycle (CreateHitCaseLifeCycleRequest createHitCaseLifeCycleRequest) {
        try {
            this.hitCaselifeCycleDataValidator.validateSaveHitCaselifeCycleData(createHitCaseLifeCycleRequest);
            final HitcaseLifecycle hitcaseLifecycle = HitcaseLifecycle.create(createHitCaseLifeCycleRequest);//entity
            this.hitcaseLifecycleRepository.saveAndFlush(hitcaseLifecycle);
            return Response.of(Long.valueOf(hitcaseLifecycle.getCaseId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateHitCaseLifeCycle(Integer id, UpdateHitCaseLifeCycleRequest updateHitCaseLifeCycleRequest) {
        try {
            this.hitCaselifeCycleDataValidator.validateUpdateHitCaselifeCycleData(updateHitCaseLifeCycleRequest);
            final HitcaseLifecycle hitcaseLifecycle = this.hitCaseLifeCycleRepositoryWrapper.findOneWithNotFoundDetection(id);
            hitcaseLifecycle.update(updateHitCaseLifeCycleRequest);
            this.hitcaseLifecycleRepository.saveAndFlush(hitcaseLifecycle);
            return Response.of(Long.valueOf(hitcaseLifecycle.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockHitCaseLifeCycle(Integer id) {
        try {
            final HitcaseLifecycle hitcaseLifecycle = this.hitCaseLifeCycleRepositoryWrapper.findOneWithNotFoundDetection(id);
            hitcaseLifecycle.setValid(false);
            hitcaseLifecycle.setStatus(Status.DELETE);
            hitcaseLifecycle.setUpdatedAt(LocalDateTime.now());
            this.hitcaseLifecycleRepository.saveAndFlush(hitcaseLifecycle);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockHitCaseLifeCycle(Integer id) {
        try {
            final HitcaseLifecycle hitcaseLifecycle = this.hitCaseLifeCycleRepositoryWrapper.findOneWithNotFoundDetection(id);
            hitcaseLifecycle.setValid(true);
            hitcaseLifecycle.setStatus(Status.DELETE);
            hitcaseLifecycle.setUpdatedAt(LocalDateTime.now());
            this.hitcaseLifecycleRepository.saveAndFlush(hitcaseLifecycle);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}

