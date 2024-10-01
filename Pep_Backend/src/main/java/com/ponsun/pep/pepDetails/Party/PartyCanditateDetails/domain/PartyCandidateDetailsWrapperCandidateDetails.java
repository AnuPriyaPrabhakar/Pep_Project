package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain;

import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.request.AbstractPartyCandidateDetailsRequest;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyReadData;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PartyCandidateDetailsWrapperCandidateDetails extends AbstractPartyCandidateDetailsRequest {

    private final PartyCandidateDetailsRepository partyCandidateDetailsRepository;

    @Transactional
    public PartyCandidateDetails findOneWithNotFoundDetection(final Integer id) {
        return this.partyCandidateDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Party Not found " + id));
    }
//    @Transactional
//    public List<PartyReadData> findOnePepIdWithNotFoundDetection(final Integer pepId){
//        return this.partyCandidateDetailsRepository.findByPepId(pepId);
//    }
    @Override
    public String toString() {
        return super.toString();
    }
}


