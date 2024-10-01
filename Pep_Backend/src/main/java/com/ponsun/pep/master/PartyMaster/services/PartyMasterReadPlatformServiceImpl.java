package com.ponsun.pep.master.PartyMaster.services;

import com.ponsun.pep.master.PartyMaster.domain.PartyMaster;
import com.ponsun.pep.master.PartyMaster.domain.PartyMasterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PartyMasterReadPlatformServiceImpl implements PartyMasterReadPlatformService {

    private final PartyMasterRepository partyMasterRepository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<PartyMaster> fetchAllParty() {
        return this.partyMasterRepository.findAll();
    }
    @Override
    public PartyMaster fetchPartyMasterById(Integer id) {
        return this.partyMasterRepository.findById(id).get();
    }
}










