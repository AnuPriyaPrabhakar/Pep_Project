package com.ponsun.pep.imageDet.services;

import com.ponsun.pep.imageDet.data.ImageDetDataValidator;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.imageDet.domain.ImageDet;
import com.ponsun.pep.imageDet.domain.ImageDetRepository;
import com.ponsun.pep.imageDet.domain.ImageDetRepositoryWrapper;
import com.ponsun.pep.imageDet.request.CreateImageDetRequest;
import com.ponsun.pep.imageDet.request.UpdateImageDetRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageDetWritePlatformServiceImpl implements ImageDetWritePlatformService {
    private final ImageDetRepository imageDetRepository;
    private final ImageDetRepositoryWrapper imageDetRepositoryWrapper;
    private final ImageDetDataValidator imageDetDataValidator;

    @Override
    @Transactional
    public Response createImageDet(CreateImageDetRequest createImageDetRequest) {
        try {
            this.imageDetDataValidator.validateSaveImageDet(createImageDetRequest);
            final ImageDet imageDet = ImageDet.create(createImageDetRequest);//entity
            this.imageDetRepository.saveAndFlush(imageDet);
            return Response.of(Long.valueOf(imageDet.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateImageDet(Integer id, UpdateImageDetRequest updateImageDetRequest) {
        try {
            this.imageDetDataValidator.validateUpdateImageDet(updateImageDetRequest);
            final ImageDet imageDet = this.imageDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            imageDet.update(updateImageDetRequest);
            this.imageDetRepository.saveAndFlush(imageDet);
            return Response.of(Long.valueOf(imageDet.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockImageDet(Integer id){
        try {
            final ImageDet imageDet = this.imageDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            imageDet.setStatus(Status.DELETE); // Or set the appropriate status
            imageDet.setUpdatedAt(LocalDateTime.now());
            this.imageDetRepository.saveAndFlush(imageDet);
            return Response.of(Long.valueOf(id));

        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockImageDet(Integer id){
        try {
            final ImageDet imageDet = this.imageDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            imageDet.setStatus(Status.ACTIVE); // Or set the appropriate status
            imageDet.setUpdatedAt(LocalDateTime.now());
            this.imageDetRepository.saveAndFlush(imageDet);
            return Response.of(Long.valueOf(id));


        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
