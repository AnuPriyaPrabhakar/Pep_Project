package com.ponsun.pep.relativeDetails.Relative.domain;

import com.ponsun.pep.relativeDetails.Relative.data.RelativeData;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelativeRepositoryWrapper {
    private final RelativeRepository relativeRepository;

    @Transactional
    public Relative findOneWithNotFoundDetection(final Integer id){
        return this.relativeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Relative Not found" + id));
    }

    @Transactional
    public List<RelativeData> findOnePepIdWithNotFoundDetection(final Integer pepId){
        return this.relativeRepository.findByPepId(pepId);
    }

    @Transactional
    public List<Relative> findOnePepIdWithRelativeMasterIdNotFoundDetection(final Integer pepId,final Integer relativeMasterId){
        return this.relativeRepository.findByPepIdAndRelativeMasterId(pepId,relativeMasterId);
    }
    @Override
    public String toString(){
        return super.toString();
    }
}
