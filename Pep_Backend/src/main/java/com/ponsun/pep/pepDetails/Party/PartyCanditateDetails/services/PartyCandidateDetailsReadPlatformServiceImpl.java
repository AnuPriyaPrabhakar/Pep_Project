package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.services;

import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyReadData;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetails;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetailsRepository;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain.PartyCandidateDetailsWrapperCandidateDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PartyCandidateDetailsReadPlatformServiceImpl implements PartyCandidateDetailsReadPlatformService {
    private final PartyCandidateDetailsRepository partyCandidateDetailsRepository;
    private final PartyCandidateDetailsWrapperCandidateDetails partyCandidateDetailsWrapper;
    private final JdbcTemplate jdbcTemplate;
//    @Override
//    public List<PartyReadData> findByPepId(Integer pepId){
//        return this.partyCandidateDetailsRepository.findByPepId(pepId);
//    }
//    @Override
//    public Party findByPepId(Integer pepId){
//        return this.partyRepository.findByPepId(pepId);
//    }
    @Override
    public PartyCandidateDetails fetchPartyById(Integer id){
        return this.partyCandidateDetailsRepository.findById(id).get();
    }
    @Override
    public List<PartyCandidateDetails> fetchAllParty(){
        return this.partyCandidateDetailsRepository.findAll();
    }
}


