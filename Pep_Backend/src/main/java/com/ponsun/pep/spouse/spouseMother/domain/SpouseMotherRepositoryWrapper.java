package com.ponsun.pep.spouse.spouseMother.domain;

import com.ponsun.pep.spouse.spouseMother.request.AbstractSpouseMotherRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SpouseMotherRepositoryWrapper extends AbstractSpouseMotherRequest {
    private final SpouseMotherRepository spouseMotherRepository;
    @Transactional
    public SpouseMother findOneWithNotFoundDetection(final Integer id) {
        return this.spouseMotherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("spouseMother Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }

}

