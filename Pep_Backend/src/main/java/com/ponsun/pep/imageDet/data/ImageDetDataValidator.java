package com.ponsun.pep.imageDet.data;

import com.ponsun.pep.imageDet.request.CreateImageDetRequest;
import com.ponsun.pep.imageDet.request.UpdateImageDetRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImageDetDataValidator {
    public void validateSaveImageDet (final CreateImageDetRequest request) {
        if (request.getPepId() == null || request.getImageName().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
        if (request.getImageName() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("ImageName parameter required");
        }
    }

    public void validateUpdateImageDet  (final UpdateImageDetRequest request) {
        if (request.getPepId() == null || request.getPepId().equals("")) {
            throw new EQAS_PEP_AppicationException("pepId parameter required");
        }
        if (request.getImageName() == null || request.getImageName().equals("")) {
            throw new EQAS_PEP_AppicationException("ImageName parameter required");
        }
    }
}

