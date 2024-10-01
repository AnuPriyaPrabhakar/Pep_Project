package com.ponsun.pep.pepDetails.Party.PartyDetails.services;



import com.ponsun.pep.pepDetails.Party.PartyDetails.domain.PartyDetails;
import com.ponsun.pep.pepDetails.Party.PartyDetails.domain.PartyDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class PartyDetailsReadServiceImpl implements PartyDetailsReadService {
    private final PartyDetailsRepository partyDetailsRepository;

    @Override
    public PartyDetails fetchPartyDetailsById(Integer id){
        return this.partyDetailsRepository.findById(id).get();
    }
    @Override
    public List<PartyDetails> fetchAllPartyDetails(){
        return this.partyDetailsRepository.findAll();
    }
}
