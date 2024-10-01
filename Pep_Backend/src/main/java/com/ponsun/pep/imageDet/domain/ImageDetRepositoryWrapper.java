package com.ponsun.pep.imageDet.domain;

import com.ponsun.pep.imageDet.request.AbstractImageDetRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageDetRepositoryWrapper extends AbstractImageDetRequest {

    private final ImageDetRepository imageDetRepository;

    @Transactional
    public ImageDet findOneWithNotFoundDetection(final Integer id) {
        return this.imageDetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ImageDet Not found " + id));

    }
    @Override
    public String toString() {
        return super.toString();
    }

}
