package com.ponsun.pep.familyDetails.MotherDetails.domain;


import com.ponsun.pep.familyDetails.MotherDetails.request.AbstractMotherDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MotherDetailsRepositoryWrapper extends AbstractMotherDetailsRequest {
    private final MotherDetailsRepository MotherDetailsRepository;

    @Transactional
    public MotherDetails findOneWithNotFoundDetection(final Integer id){
        return this.MotherDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("FamilyDetails Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }
}
