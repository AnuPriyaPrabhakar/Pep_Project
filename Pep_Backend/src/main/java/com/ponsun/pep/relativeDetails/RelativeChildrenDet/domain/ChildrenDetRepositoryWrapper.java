package com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain;


import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.AbstractChildrenDetRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildrenDetRepositoryWrapper extends AbstractChildrenDetRequest {

    private final ChildrenDetRepository childrenDetRepository;

    @Transactional
    public ChildrenDet findOneWithNotFoundDetection (final Integer id) {
        return this.childrenDetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ChildrenDetails Not found " + id));
    }

    @Transactional
    public List<ChildrenDet> findOnePepIdWithNotFoundDetection(final Integer pepId){
        return this.childrenDetRepository.findByPepId(pepId);
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
