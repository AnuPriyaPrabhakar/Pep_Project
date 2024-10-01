package com.ponsun.pep.master.District.domain;

import com.ponsun.pep.master.District.request.AbstractDistrictRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistrictRepositoryWrapper extends AbstractDistrictRequest {

    private final DistrictRepository districtRepository;

    @Transactional
    public District findOneWithNotFoundDetection(final Integer id) {
        return this.districtRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("District Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
