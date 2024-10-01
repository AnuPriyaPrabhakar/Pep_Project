package com.ponsun.pep.master.AssociatedList.domain;

import com.ponsun.pep.master.AssociatedList.request.AbstractAssociatedListRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AssociatedListRepositoryWrapper extends AbstractAssociatedListRequest {
    private final AssociatedListRepository associatedListRepository;
    @Transactional
    public AssociatedList findOneWithNotFoundDetection(final Integer id){
        return this.associatedListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AssociatedList Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }

}
