package com.ponsun.pep.master.gender.domain;


import com.ponsun.pep.master.gender.request.AbstractGenderBaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GenderRepositoryWrapper extends AbstractGenderBaseRequest {
    private final GenderRepository genderRepository;

    @Transactional
    public Gender findOneWithNotFoundDetection(final Integer id) {
        return this.genderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Gender Not found " + id));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
