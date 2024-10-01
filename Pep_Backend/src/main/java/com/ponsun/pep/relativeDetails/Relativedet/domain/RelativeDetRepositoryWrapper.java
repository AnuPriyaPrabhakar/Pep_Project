package com.ponsun.pep.relativeDetails.Relativedet.domain;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelativeDetRepositoryWrapper {

    private final RelativeDetRepository relativeDetRepository;

    @Transactional
    public RelativeDet findWithNotFoundDetection(final Integer id){
        return this.relativeDetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PepRelativeDet" + id));
    }

    @Transactional
    public List<RelativeDet> findOnePepIdWithNotFoundDetection(final Integer pepId){
        return this.relativeDetRepository.findByPepId(pepId);
    }

    @Override
    public String toString(){
        return super.toString();
    }

}
