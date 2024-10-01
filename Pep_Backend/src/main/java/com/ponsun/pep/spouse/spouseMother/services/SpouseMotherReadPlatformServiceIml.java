package com.ponsun.pep.spouse.spouseMother.services;

import com.ponsun.pep.spouse.spouseMother.domain.SpouseMother;
import com.ponsun.pep.spouse.spouseMother.domain.SpouseMotherRepository;
import com.ponsun.pep.spouse.spouseMother.domain.SpouseMotherRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpouseMotherReadPlatformServiceIml implements SpouseMotherReadPlatformService {
    private final SpouseMotherRepositoryWrapper spouseMotherRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final SpouseMotherRepository spouseMotherRepository;

    @Override
    public SpouseMother fetchSpouseMotherById(Integer id){

        return this.spouseMotherRepository.findById(id).get();
    }

    @Override
    public List<SpouseMother> fetchAllSpouseMother(){
        return this.spouseMotherRepository.findAll();
    }
}
