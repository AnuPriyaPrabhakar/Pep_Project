package com.ponsun.pep.familyDetails.HufDetails.domain;


import com.ponsun.pep.familyDetails.HufDetails.request.AbstractHufDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HufDetailsRepositoryWrapper extends AbstractHufDetailsRequest {
    private final HufDetailsRepository hufDetailsRepository;

    @Transactional
    public HufDetails findOneWithNotFoundDetection(final Integer id){
        return this.hufDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("FamilyDetails Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }
}
