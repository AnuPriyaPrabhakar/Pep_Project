package com.ponsun.pep.spouse.spouseDetails.domain;


import com.ponsun.pep.spouse.spouseDetails.request.AbstractSpouseDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SpouseDetailsRepositoryWrapper extends AbstractSpouseDetailsRequest {
    private final SpouseDetailsRepository spouseDetailsRepository;

    @Transactional
    public SpouseDetails findOneWithNotFoundDetection(final Integer id){
        return this.spouseDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("FamilyDetails Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }
}
