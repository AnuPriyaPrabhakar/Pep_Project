package com.ponsun.pep.master.RelativeConfig.domain;

import com.ponsun.pep.master.RelativeConfig.request.AbstractRelativeRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class RelativeConfigRepositoryWrapper extends AbstractRelativeRequest {

    private final RelativeConfigRepository relativeConfigRepository;
    @Transactional
    public RelativeConfig findOneWithNotFoundDetection (final Integer id) {
        return this.relativeConfigRepository.findById(id).orElseThrow(() -> new  EntityNotFoundException("Relative Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }

}