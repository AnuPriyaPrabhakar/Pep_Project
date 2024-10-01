package com.ponsun.pep.master.PartyMaster.services;

import com.ponsun.pep.master.PartyMaster.data.PartyMasterDataValidator;
import com.ponsun.pep.master.PartyMaster.domain.PartyMaster;
import com.ponsun.pep.master.PartyMaster.domain.PartyMasterRepository;
import com.ponsun.pep.master.PartyMaster.domain.PartyMasterRepositoryWrapper;
import com.ponsun.pep.master.PartyMaster.request.CreatePartyMasterRequest;
import com.ponsun.pep.master.PartyMaster.request.UpdatePartyMasterRequest;
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
public class PartyMasterWritePlatformServiceImpl implements  PartyMasterWritePlatformService{


    private final PartyMasterRepository partyMasterRepository;
    private final PartyMasterRepositoryWrapper partyMasterRepositoryWrapper;
    private final PartyMasterDataValidator partyMasterDataValidator;

    @Transactional
    public Response createPartyMaster(CreatePartyMasterRequest createPartyMasterRequest){
        try{
            this.partyMasterDataValidator.validateSavePartyMaster(createPartyMasterRequest);
            final PartyMaster partyMaster = PartyMaster.create(createPartyMasterRequest);
            this.partyMasterRepository.saveAndFlush(partyMaster);
            return Response.of(Long.valueOf(partyMaster.getId()));
        }catch(DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateParty(Integer id, UpdatePartyMasterRequest updatePartyMasterRequest){
        try{
            this.partyMasterDataValidator.validateUpdatePartyMaster(updatePartyMasterRequest);
            final  PartyMaster partyMaster = this.partyMasterRepositoryWrapper.findOneWithNotFoundDetection(id);
            partyMaster.update(updatePartyMasterRequest);
            this.partyMasterRepository.saveAndFlush(partyMaster);
            return Response.of(Long.valueOf(partyMaster.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockPartyMaster(Integer id){
        try{
            final  PartyMaster partyMaster = this.partyMasterRepositoryWrapper.findOneWithNotFoundDetection(id);
            partyMaster.setStatus(Status.DELETE);
            partyMaster.setUpdatedAt(LocalDateTime.now());
            this.partyMasterRepository.saveAndFlush(partyMaster);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockPartyMaster(Integer id){
        try{
            final  PartyMaster partyMaster = this.partyMasterRepositoryWrapper.findOneWithNotFoundDetection(id);
            partyMaster.setStatus(Status.ACTIVE);
            partyMaster.setUpdatedAt(LocalDateTime.now());
            this.partyMasterRepository.saveAndFlush(partyMaster);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
