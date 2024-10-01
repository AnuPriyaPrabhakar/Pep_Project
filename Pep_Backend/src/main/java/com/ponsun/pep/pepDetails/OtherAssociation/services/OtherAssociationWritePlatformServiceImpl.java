package com.ponsun.pep.pepDetails.OtherAssociation.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.pepDetails.AkaDet.domain.AkaDet;
import com.ponsun.pep.pepDetails.OtherAssociation.data.OtherAssociationData;
import com.ponsun.pep.pepDetails.OtherAssociation.data.OtherAssociationDataValidator;
import com.ponsun.pep.pepDetails.OtherAssociation.domain.OtherAssociation;
import com.ponsun.pep.pepDetails.OtherAssociation.domain.OtherAssociationRepository;
import com.ponsun.pep.pepDetails.OtherAssociation.domain.OtherAssociationRepositoryWrapper;
import com.ponsun.pep.pepDetails.OtherAssociation.request.CreateOtherAssociationRequest;
import com.ponsun.pep.pepDetails.OtherAssociation.request.UpdateOtherAssociationRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OtherAssociationWritePlatformServiceImpl implements OtherAssociationWritePlatformService {
    private final OtherAssociationRepository otherAssociationRepository;
    private final OtherAssociationRepositoryWrapper otherAssociationRepositoryWrapper;
    private final OtherAssociationDataValidator otherAssociationDataValidator;

    @Transactional
    public Response createOtherAssociation(CreateOtherAssociationRequest createOtherAssociationRequest){
        try{
            this.otherAssociationDataValidator.validateSaveOtherAssociationData(createOtherAssociationRequest);
            final OtherAssociation otherAssociation = OtherAssociation.create(createOtherAssociationRequest);
            this.otherAssociationRepository.saveAndFlush(otherAssociation);
            return Response.of(Long.valueOf(otherAssociation.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deactive(Integer pepId, Integer euid){
        try{
            List<OtherAssociationData> otherAssociationDataList = this.otherAssociationRepositoryWrapper.findOnePepIdWithNotFoundDetection(pepId);
            ModelMapper modelMapper = new ModelMapper();

            for (OtherAssociationData otherAssociationData : otherAssociationDataList) {
                OtherAssociation request = modelMapper.map(otherAssociationData, OtherAssociation.class);
                request.setEuid(euid);
                request.setStatus(Status.DELETE);
                request.onUpdate();
                this.otherAssociationRepository.saveAndFlush(request);
            }
            return new Response();
            //return Response.of(request.getId());
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateOtherAssociation(Integer id, UpdateOtherAssociationRequest updateOtherAssociationRequest){
        try{
            this.otherAssociationDataValidator.validateUpdateOtherAssociationData(updateOtherAssociationRequest);
           final OtherAssociation otherAssociation = this.otherAssociationRepositoryWrapper.findOneWithNotFoundDetection(id);
            otherAssociation.update(updateOtherAssociationRequest);
            return Response.of(Long.valueOf(otherAssociation.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockOtherAssociation(Integer id){
        try{
            final OtherAssociation otherAssociation = this.otherAssociationRepositoryWrapper.findOneWithNotFoundDetection(id);
            otherAssociation.setStatus(Status.DELETE);
            otherAssociation.setUpdatedAt(LocalDateTime.now());
            this.otherAssociationRepository.saveAndFlush(otherAssociation);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockOtherAssociation(Integer id){
        try{
            final OtherAssociation otherAssociation = this.otherAssociationRepositoryWrapper.findOneWithNotFoundDetection(id);
            otherAssociation.setStatus(Status.DELETE);
            otherAssociation.setUpdatedAt(LocalDateTime.now());
            this.otherAssociationRepository.saveAndFlush(otherAssociation);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
