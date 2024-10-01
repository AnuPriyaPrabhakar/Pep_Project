package com.ponsun.pep.spouse.spouseDetails.services;

import com.ponsun.pep.spouse.spouseDetails.domain.SpouseDetails;
import com.ponsun.pep.spouse.spouseDetails.domain.SpouseDetailsRepository;
import com.ponsun.pep.spouse.spouseDetails.domain.SpouseDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpouseDetailsReadPlatformServiceImpl implements SpouseDetailsReadPlatformService {

    private final SpouseDetailsRepository spouseDetailsRepository;
    private final JdbcTemplate jdbcTemplate;
    private final SpouseDetailsRepositoryWrapper spouseDetailsRepositoryWrapper;

    @Override
    public SpouseDetails fetchSpouseDetailsById(Integer id){
        return this.spouseDetailsRepository.findById(id).get();
    }
    @Override
    public List<SpouseDetails> fetchAllSpouseDetails(){
        return this.spouseDetailsRepository.findAll();
    }
}

