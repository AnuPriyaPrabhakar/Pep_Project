package com.ponsun.pep.master.RelativeConfig.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.RelativeConfig.domain.RelativeConfig;
import com.ponsun.pep.master.RelativeConfig.domain.RelativeConfigRepository;
import com.ponsun.pep.master.RelativeConfig.domain.RelativeConfigRepositoryWrapper;
import com.ponsun.pep.master.RelativeConfig.request.CreateRelativeRequest;
import com.ponsun.pep.master.RelativeConfig.request.UpdateRelativeRequest;
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
public class RelativeConfigWritePlatformServiceImpl implements RelativeConfigWritePlatformService {

    private final RelativeConfigRepository relativeConfigRepository;
    private final RelativeConfigRepositoryWrapper relativeConfigRepositoryWrapper;

    @Transactional
    public Response createRelative(CreateRelativeRequest createRelativeRequest) {
        try {
            final RelativeConfig relativeConfig = RelativeConfig.create(createRelativeRequest);//entity
            this.relativeConfigRepository.saveAndFlush(relativeConfig);
            return Response.of(Long.valueOf(relativeConfig.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Response updateRelative(Integer id, UpdateRelativeRequest updateRelativeRequest) {
        try {
            RelativeConfig relativeConfig = this.relativeConfigRepositoryWrapper.findOneWithNotFoundDetection(id);

            relativeConfig.setName(updateRelativeRequest.getName());
//            country.setDt(updateCountryRequest.getDt());
            relativeConfig.setStatus(Status.ACTIVE);
            relativeConfig.setUpdatedAt(LocalDateTime.now());
            return Response.of(Long.valueOf(relativeConfig.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response deleteRelative(Integer id) {
        try {
            // Find the existing country entity by ID
            Optional<RelativeConfig> optionalRelative = relativeConfigRepository.findById(id);
            if (optionalRelative.isPresent()) {
                // Delete the entity from the repository
                relativeConfigRepository.delete(optionalRelative.get());
                return Response.of(Long.valueOf(id));
            } else {
                // Handle the case where the country with the given ID is not found
                throw new EntityNotFoundException("Country not found with ID: " + id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}