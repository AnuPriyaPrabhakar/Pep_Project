package com.ponsun.pep.pepDetails.OtherAssociation.domain;

import com.ponsun.pep.pepDetails.OtherAssociation.data.OtherAssociationData;
import com.ponsun.pep.pepDetails.OtherAssociation.request.AbstractOtherAssociationRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OtherAssociationRepositoryWrapper extends AbstractOtherAssociationRequest {
    private final OtherAssociationRepository otherAssociationRepository;
    @Transactional
    public OtherAssociation findOneWithNotFoundDetection(final Integer id){
        return this.otherAssociationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Other Association Not found" + id));
    }
    @Transactional
    public List<OtherAssociationData> findOnePepIdWithNotFoundDetection(final Integer pepId){
        return this.otherAssociationRepository.findByPepId(pepId);
    }
    @Override
    public String toString(){ return super.toString();}
}
