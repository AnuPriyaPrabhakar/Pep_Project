package com.ponsun.pep.spouse.spouseHuf.domain;

import com.ponsun.pep.spouse.spouseHuf.request.AbstractSpouseHufRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SpouseHufRepositoryWrapper extends AbstractSpouseHufRequest {
    private final SpouseHufRepository spouseHufRepository;
    @Transactional
    public SpouseHuf findOneWithNotFoundDetection(final Integer id) {
        return this.spouseHufRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("SpouseHuf Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }

}

