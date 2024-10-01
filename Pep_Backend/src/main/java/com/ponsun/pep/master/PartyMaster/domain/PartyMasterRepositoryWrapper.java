package com.ponsun.pep.master.PartyMaster.domain;

import com.ponsun.pep.master.PartyMaster.request.AbstractPartyMasterRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartyMasterRepositoryWrapper extends AbstractPartyMasterRequest {
    private final PartyMasterRepository partyMasterRepository;
    @Transactional
    public PartyMaster findOneWithNotFoundDetection(final Integer id) {
        return this.partyMasterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PartyMaster Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }
}