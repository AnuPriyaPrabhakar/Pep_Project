package com.ponsun.pep.familyDetails.FatherDetails.domain;

import com.ponsun.pep.familyDetails.FatherDetails.request.AbstractFatherDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FatherDetailsRepositoryWrapper extends AbstractFatherDetailsRequest {
    private final FatherDetailsRepository fatherDetailsRepository;

    @Transactional
    public FatherDetails findOneWithNotFoundDetection(final Integer id){
        return this.fatherDetailsRepository.findById(id).orElseThrow(()->  new EntityNotFoundException("FatherDetails Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }
}
