package com.ponsun.pep.master.designation.services;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.designation.data.DesignationDataValidator;
import com.ponsun.pep.master.designation.domain.Designation;
import com.ponsun.pep.master.designation.domain.DesignationRepository;
import com.ponsun.pep.master.designation.domain.DesignationRepositoryWrapper;
import com.ponsun.pep.master.designation.request.CreateDesignationRequest;
import com.ponsun.pep.master.designation.request.UpdateDesignationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DesignationWritePlatformServiceImpl implements DesignationWritePlatformService {

    private final DesignationRepository designationRepository;
    private final DesignationRepositoryWrapper designationRepositoryWrapper;
    private final DesignationDataValidator designationDataValidator;

    @Transactional
    public Response createDesignation(CreateDesignationRequest createDesignationRequest) {
        try {
            this.designationDataValidator.validateSaveDesignation(createDesignationRequest);
            final Designation designation = Designation.create(createDesignationRequest);//entity
            this.designationRepository.saveAndFlush(designation);
            return Response.of(Long.valueOf(designation.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateDesignation(Integer id, UpdateDesignationRequest updateDesignationRequest) {
        try {
            this.designationDataValidator.validateUpdateDesignation(updateDesignationRequest);
            final Designation designation = this.designationRepositoryWrapper.findOneWithNotFoundDetection(id);
            designation.update(updateDesignationRequest);
            return Response.of(Long.valueOf(designation.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Response blockDesignation(Integer id) {
        try {
            final Designation designation = this.designationRepositoryWrapper.findOneWithNotFoundDetection(id);
            designation.setStatus(Status.DELETE);
            designation.setUpdatedAt(LocalDateTime.now());
            this.designationRepository.saveAndFlush(designation);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockDesignation(Integer id) {
        try {
            final Designation designation = this.designationRepositoryWrapper.findOneWithNotFoundDetection(id);
            designation.setStatus(Status.ACTIVE);
            designation.setUpdatedAt(LocalDateTime.now());
            this.designationRepository.saveAndFlush(designation);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}