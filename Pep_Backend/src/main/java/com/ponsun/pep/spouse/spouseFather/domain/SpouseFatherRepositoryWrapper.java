package com.ponsun.pep.spouse.spouseFather.domain;

import com.ponsun.pep.spouse.spouseFather.request.AbstractSpouseFatherRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SpouseFatherRepositoryWrapper extends AbstractSpouseFatherRequest {
    private final SpouseFatherRepository spouseFatherRepository;
    @Transactional
    public SpouseFather findOneWithNotFoundDetection(final Integer id) {
        return this.spouseFatherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("spouseMother Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }

}

