package com.ponsun.pep.spouse.spouseHuf.services;

import com.ponsun.pep.spouse.spouseHuf.domain.SpouseHuf;
import com.ponsun.pep.spouse.spouseHuf.domain.SpouseHufRepository;
import com.ponsun.pep.spouse.spouseHuf.domain.SpouseHufRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpouseHufReadPlatformServiceIml implements SpouseHufReadPlatformService {
    private final SpouseHufRepositoryWrapper countryRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final SpouseHufRepository spouseHufRepository;

    @Override
    public SpouseHuf fetchSpouseHufById(Integer id){

        return this.spouseHufRepository.findById(id).get();

    }
    @Override
    public List<SpouseHuf> fetchAllSpouseHuf(){
        return this.spouseHufRepository.findAll();
    }
}
