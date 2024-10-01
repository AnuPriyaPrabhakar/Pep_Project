package com.ponsun.pep.RequestDescription.services;

import com.ponsun.pep.RequestDescription.data.RequestDescriptionDataValidator;
import com.ponsun.pep.RequestDescription.domain.RequestDescription;
import com.ponsun.pep.RequestDescription.domain.RequestDescriptionRepository;
import com.ponsun.pep.RequestDescription.domain.RequestDescriptionRepositoryWrapper;
import com.ponsun.pep.RequestDescription.request.CreateRequestDescriptionRequest;
import com.ponsun.pep.RequestDescription.request.UpdateRequestDescriptionRequest;
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
public class RequestDescriptionWritePlatformServiceImpl implements RequestDescriptionWritePlatformService{
    private final RequestDescriptionRepository requestDescriptionRepository;
    private final RequestDescriptionRepositoryWrapper requestDescriptionRepositoryWrapper;
    private  final RequestDescriptionDataValidator requestDescriptionDataValidator;
    @Transactional
    public Response createRequestDescription(CreateRequestDescriptionRequest createRequestDescriptionRequest){
        try{
            this.requestDescriptionDataValidator.validateSaveRequestDescription(createRequestDescriptionRequest);
            final RequestDescription requestDescription = RequestDescription.create(createRequestDescriptionRequest);
            this.requestDescriptionRepository.saveAndFlush(requestDescription);
            return Response.of(Long.valueOf(requestDescription.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateRequestDescription(Integer id, UpdateRequestDescriptionRequest updateRequestDescriptionRequest){
        try{
            this.requestDescriptionDataValidator.validateUpdateRequestDescription(updateRequestDescriptionRequest);
            final RequestDescription requestDescription = this.requestDescriptionRepositoryWrapper.findOneWithNotFoundDetection(id);
            requestDescription.update(updateRequestDescriptionRequest);
            this.requestDescriptionRepository.saveAndFlush(requestDescription);
            return Response.of(Long.valueOf(requestDescription.getId()));
        }catch (DataIntegrityViolationException e){
            throw  new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockRequestDescription(Integer id){
        try{
            final RequestDescription requestDescription = this.requestDescriptionRepositoryWrapper.findOneWithNotFoundDetection(id);
            requestDescription.setStatus(Status.DELETE);
            requestDescription.setUpdatedAt(LocalDateTime.now());
            this.requestDescriptionRepository.saveAndFlush(requestDescription);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockRequestDescription(Integer id){
        try{
            final RequestDescription requestDescription = this.requestDescriptionRepositoryWrapper.findOneWithNotFoundDetection(id);
            requestDescription.setStatus(Status.ACTIVE);
            requestDescription.setUpdatedAt(LocalDateTime.now());
            this.requestDescriptionRepository.saveAndFlush(requestDescription);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
