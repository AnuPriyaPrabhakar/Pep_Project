package com.ponsun.pep.master.status.services;


import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.status.domain.Status;
import com.ponsun.pep.master.status.domain.StatusRepository;
import com.ponsun.pep.master.status.domain.StatusRepositoryWrapper;
import com.ponsun.pep.master.status.request.CreateStatusRequest;
import com.ponsun.pep.master.status.request.UpdateStatusRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j

public class StatusWritePlatformServiceImpl implements StatusWritePlatformService {
    private final StatusRepository statusRepository;
    private final StatusRepositoryWrapper statusRepositoryWrapper;

    public Response createStatus(CreateStatusRequest createStatusRequest) {
        try {
            final Status status = Status.create(createStatusRequest);
            this.statusRepository.saveAndFlush(status);
            return Response.of(Long.valueOf(status.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateStatus(Integer id, UpdateStatusRequest updateStatusRequest) {
        try {
            Status status = this.statusRepositoryWrapper.findOneWithNotFoundDetection(id);
            status.setCode(updateStatusRequest.getCode());
            status.setName(updateStatusRequest.getName());
            status.setValid(updateStatusRequest.getValid());
            status = this.statusRepository.saveAndFlush(status);
            return Response.of(Long.valueOf(status.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockStatus(Integer id) {
        try {
            final Status status = this.statusRepositoryWrapper.findOneWithNotFoundDetection(id);
            status.setValid(false);
            status.setStatus(com.ponsun.pep.common.entity.Status.DELETE);
            status.setUpdatedAt(LocalDateTime.now());
            this.statusRepository.saveAndFlush(status);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockStatus(Integer id) {
        try {
            final Status status = this.statusRepositoryWrapper.findOneWithNotFoundDetection(id);
            status.setValid(true);
            status.setStatus(com.ponsun.pep.common.entity.Status.DELETE);
            status.setUpdatedAt(LocalDateTime.now());
            this.statusRepository.saveAndFlush(status);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}

