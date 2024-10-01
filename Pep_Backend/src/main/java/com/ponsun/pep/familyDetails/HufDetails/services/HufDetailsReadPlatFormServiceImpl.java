package com.ponsun.pep.familyDetails.HufDetails.services;

import com.ponsun.pep.familyDetails.HufDetails.domain.HufDetails;
import com.ponsun.pep.familyDetails.HufDetails.domain.HufDetailsRepository;
import com.ponsun.pep.familyDetails.HufDetails.domain.HufDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HufDetailsReadPlatFormServiceImpl implements HufDetailsReadPlatFormService {

    private final HufDetailsRepository hufDetailsRepository;
    private final JdbcTemplate jdbcTemplate;
    private final HufDetailsRepositoryWrapper hufDetailsRepositoryWrapper;

    @Override
    public HufDetails fetchHufDetailsById(Integer id){
        return this.hufDetailsRepository.findById(id).get();
    }
    @Override
    public List<HufDetails> fetchAllHufDetails(){
        return this.hufDetailsRepository.findAll();
    }
}

