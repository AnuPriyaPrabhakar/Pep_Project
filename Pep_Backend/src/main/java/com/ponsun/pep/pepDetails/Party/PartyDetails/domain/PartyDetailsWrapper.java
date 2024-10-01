package com.ponsun.pep.pepDetails.Party.PartyDetails.domain;


import com.ponsun.pep.pepDetails.Party.PartyDetails.request.AbstractPartyDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyDetailsWrapper  extends AbstractPartyDetailsRequest {

    private final PartyDetailsRepository PartyDetailsRepository;

    @Transactional
    public PartyDetails findOneWithNotFoundDetection(final Integer id) {
        return this.PartyDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PartyDetails Not found " + id));
    }

    @Transactional
    public List<PartyDetails> findOnePepIdWithNotFoundDetection(final Integer pepId){
        return this.PartyDetailsRepository.findByPepId(pepId);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}