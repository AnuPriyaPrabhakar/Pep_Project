package com.ponsun.pep.pepDetails.AkaDet.services;

import com.ponsun.pep.pepDetails.AkaDet.data.AkaDetDataValidator;
import com.ponsun.pep.pepDetails.AkaDet.domain.AkaDet;
import com.ponsun.pep.pepDetails.AkaDet.domain.AkaDetRepository;
import com.ponsun.pep.pepDetails.AkaDet.domain.AkaDetRepositoryWrapper;
import com.ponsun.pep.pepDetails.AkaDet.request.CreateAkaDetRequest;
import com.ponsun.pep.pepDetails.AkaDet.request.UpdateAkaDetRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AkaDetWritePlatformServiceImpl implements AkaDetWritePlatformService{
    private final AkaDetRepository akaDetRepository;
    private final AkaDetRepositoryWrapper akaDetRepositoryWrapper;
    private final AkaDetDataValidator akaDetDataValidator;

    @Override
    @Transactional
    public Response createAkaDet(CreateAkaDetRequest createAkaDetRequest) {
        try {
            this.akaDetDataValidator.validateSaveAkaDet(createAkaDetRequest);
            final AkaDet akaDet = AkaDet.create(createAkaDetRequest);//entity
            this.akaDetRepository.saveAndFlush(akaDet);
            return Response.of(Long.valueOf(akaDet.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateAkaDet(Integer id, UpdateAkaDetRequest updateAkaDetRequest) {
        try {
            this.akaDetDataValidator.validateUpdateAkaDet(updateAkaDetRequest);
            final AkaDet akaDet = this.akaDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            akaDet.update(updateAkaDetRequest);
            this.akaDetRepository.saveAndFlush(akaDet);
            return Response.of(Long.valueOf(akaDet.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response deactive(Integer pepId, Integer euid){
        try{
            List<AkaDet> akaDet = this.akaDetRepositoryWrapper.findOnePepIdWithNotFoundDetection(pepId);
            Response response = null;
            for (AkaDet akaDets : akaDet) {
                akaDets.setEuid(euid);
                akaDets.setStatus(Status.DELETE);
                akaDets.setUpdatedAt(LocalDateTime.now());
                response = Response.of(akaDets.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockAkaDet(Integer id){
        try {
            final AkaDet akaDet = this.akaDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            akaDet.setStatus(Status.DELETE); // Or set the appropriate status
            akaDet.setUpdatedAt(LocalDateTime.now());
            this.akaDetRepository.saveAndFlush(akaDet);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockAkaDet(Integer id){
        try {
            final AkaDet akaDet = this.akaDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            akaDet.setStatus(Status.ACTIVE); // Or set the appropriate status
            akaDet.setUpdatedAt(LocalDateTime.now());
            this.akaDetRepository.saveAndFlush(akaDet);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
