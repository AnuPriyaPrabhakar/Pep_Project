package com.ponsun.pep.familyDetails.MotherDetails.services;

import com.ponsun.pep.familyDetails.MotherDetails.domain.MotherDetails;
import com.ponsun.pep.familyDetails.MotherDetails.domain.MotherDetailsRepository;
import com.ponsun.pep.familyDetails.MotherDetails.domain.MotherDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MotherDetailsReadPlatformServiceImpl implements MotherDetailsReadPlatformService {

    private final MotherDetailsRepository motherDetailsRepository;
    private final JdbcTemplate jdbcTemplate;
    private final MotherDetailsRepositoryWrapper motherDetailsRepositoryWrapper;

    @Override
    public MotherDetails fetchMotherDetailsById(Integer id){
        return this.motherDetailsRepository.findById(id).get();
    }
    @Override
    public List<MotherDetails> fetchAllMotherDetails(){
        return this.motherDetailsRepository.findAll();
    }
}

