package com.ponsun.pep.relativeDetails.FamilyDocuments.services;


import com.ponsun.pep.relativeDetails.FamilyDocuments.data.FamilyDocumentsDataValidator;
import com.ponsun.pep.relativeDetails.FamilyDocuments.domain.FamilyDocuments;
import com.ponsun.pep.relativeDetails.FamilyDocuments.domain.FamilyDocumentsRepository;
import com.ponsun.pep.relativeDetails.FamilyDocuments.domain.FamilyDocumentsRepositoryWrapper;
import com.ponsun.pep.relativeDetails.FamilyDocuments.request.CreateFamilyDocumentsRequest;
import com.ponsun.pep.relativeDetails.FamilyDocuments.request.UpdateFamilyDocumentsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j

public class FamilyDocumentsWritePlatformServiceImpl implements FamilyDocumentsWritePlatformService {

    private final FamilyDocumentsRepository familyDocumentsRepository;
    private final FamilyDocumentsRepositoryWrapper familyDocumentsRepositoryWrapper;
    private final FamilyDocumentsDataValidator familyDocumentsDataValidator;

    @Override
    public Response createFamilyDocuments(CreateFamilyDocumentsRequest createFamilyDocumentsRequest) {
        try {
            this.familyDocumentsDataValidator.validateSaveFamilyDocuments(createFamilyDocumentsRequest);
            final FamilyDocuments familyDocuments = FamilyDocuments.create(createFamilyDocumentsRequest);//entity
            this.familyDocumentsRepository.saveAndFlush(familyDocuments);
            return Response.of(familyDocuments.getId());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Response updateFamilyDocuments(Integer id, UpdateFamilyDocumentsRequest updateFamilyDocumentsRequest) {
        try {
            this.familyDocumentsDataValidator.validateUpdateFamilyDocuments(updateFamilyDocumentsRequest);
            final FamilyDocuments familyDocuments = this.familyDocumentsRepositoryWrapper.findOneWithNotFoundDetection(id);
            familyDocuments.update(updateFamilyDocumentsRequest);
            this.familyDocumentsRepository.saveAndFlush(familyDocuments);
            return Response.of(familyDocuments.getId());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}