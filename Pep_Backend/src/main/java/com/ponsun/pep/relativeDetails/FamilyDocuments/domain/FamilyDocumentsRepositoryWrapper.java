package com.ponsun.pep.relativeDetails.FamilyDocuments.domain;


import com.ponsun.pep.relativeDetails.FamilyDocuments.request.AbstractFamilyDocumentsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class FamilyDocumentsRepositoryWrapper extends AbstractFamilyDocumentsRequest {


    private final FamilyDocumentsRepository familyDocumentsRepository;

    @Transactional
    public FamilyDocuments findOneWithNotFoundDetection(final Integer id){
        return this.familyDocumentsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AssociatedList Not found " + id) );

    }
    @Override
    public String toString(){
        return super.toString();
    }


}
