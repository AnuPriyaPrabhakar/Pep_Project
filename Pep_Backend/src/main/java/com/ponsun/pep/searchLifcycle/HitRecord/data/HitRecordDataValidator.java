package com.ponsun.pep.searchLifcycle.HitRecord.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.searchLifcycle.HitRecord.request.CreateHitRecordRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HitRecordDataValidator {
    public void validateSaveHitData(final CreateHitRecordRequest request){
        if(request.getSearchId() == null || request.getSearchId().equals("")){
            throw new EQAS_PEP_AppicationException("HitRecord SearchId parameter required");
        }
    }
}
