package com.ponsun.pep.familyDetails.FatherDetails.services;

import com.ponsun.pep.familyDetails.FatherDetails.domain.FatherDetails;
import com.ponsun.pep.familyDetails.FatherDetails.domain.FatherDetailsRepository;
import com.ponsun.pep.familyDetails.FatherDetails.domain.FatherDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class FatherDetailsReadPlatFormServiceImpl implements  FatherDetailsReadPlatFormService{
    private final FatherDetailsRepository fatherDetailsRepository;
    private final JdbcTemplate jdbcTemplate;
    private final FatherDetailsRepositoryWrapper fatherDetailsRepositoryWrapper;

    @Override
    public FatherDetails fetchFatherDetailsById(Integer id){
        return this.fatherDetailsRepository.findById(id).get();
    }
    @Override
    public List<FatherDetails> fetchAllFatherDetails(){
        return this.fatherDetailsRepository.findAll();
    }
}

