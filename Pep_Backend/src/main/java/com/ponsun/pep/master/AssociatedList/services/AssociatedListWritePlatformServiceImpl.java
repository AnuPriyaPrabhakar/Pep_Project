package com.ponsun.pep.master.AssociatedList.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.AssociatedList.data.AssociatedListDataValidator;
import com.ponsun.pep.master.AssociatedList.domain.AssociatedList;
import com.ponsun.pep.master.AssociatedList.domain.AssociatedListRepository;
import com.ponsun.pep.master.AssociatedList.domain.AssociatedListRepositoryWrapper;
import com.ponsun.pep.master.AssociatedList.request.CreateAssociatedListRequest;
import com.ponsun.pep.master.AssociatedList.request.UpdateAssociatedListRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssociatedListWritePlatformServiceImpl implements AssociatedListWritePlatformService{
    private final AssociatedListRepository associatedListRepository;
    private final AssociatedListRepositoryWrapper associatedListRepositoryWrapper;
    private final AssociatedListDataValidator associatedListDataValidator;

    @Override
    @Transactional
    public Response createAssociatedList(CreateAssociatedListRequest createAssociatedListRequest) {
        try {
            this.associatedListDataValidator.validateSaveAssociatedList(createAssociatedListRequest);
            final AssociatedList associatedList = AssociatedList.create(createAssociatedListRequest);//entity
            this.associatedListRepository.saveAndFlush(associatedList);
            return Response.of(Long.valueOf(associatedList.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateAssociatedList(Integer id, UpdateAssociatedListRequest updateAssociatedListRequest) {
        try {
            this.associatedListDataValidator.validateUpdateAssociatedList(updateAssociatedListRequest);
            final AssociatedList associatedList = this.associatedListRepositoryWrapper.findOneWithNotFoundDetection(id);
            associatedList.update(updateAssociatedListRequest);
            this.associatedListRepository.saveAndFlush(associatedList);
            return Response.of(Long.valueOf(associatedList.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockAssociatedList(Integer id){
        try {
            final AssociatedList associatedList = this.associatedListRepositoryWrapper.findOneWithNotFoundDetection(id);
            associatedList.setStatus(Status.DELETE); // Or set the appropriate status
            associatedList.setUpdatedAt(LocalDateTime.now());
            this.associatedListRepository.saveAndFlush(associatedList);
            return Response.of(Long.valueOf(id));

        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockAssociatedList(Integer id){
        try {
            final AssociatedList associatedList = this.associatedListRepositoryWrapper.findOneWithNotFoundDetection(id);
            associatedList.setStatus(Status.ACTIVE); // Or set the appropriate status
            associatedList.setUpdatedAt(LocalDateTime.now());
            this.associatedListRepository.saveAndFlush(associatedList);
            return Response.of(Long.valueOf(id));

        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
