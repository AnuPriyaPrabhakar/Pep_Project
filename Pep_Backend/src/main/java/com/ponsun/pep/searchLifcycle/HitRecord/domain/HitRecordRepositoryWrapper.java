package com.ponsun.pep.searchLifcycle.HitRecord.domain;

import com.ponsun.pep.searchLifcycle.HitRecord.request.AbstractHitRecordBaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HitRecordRepositoryWrapper extends AbstractHitRecordBaseRequest {
    private final HitRecordRepository hitRecordRepository;

    @Transactional
    public HitRecord findOneWithNotFoundDetection(final Integer id){
        HitRecord hitRecord = this.hitRecordRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("HitRecord Not Found with Id: "+ id));
        return hitRecord;
    }
    @Override
    public String toString() {return super.toString();}
}
