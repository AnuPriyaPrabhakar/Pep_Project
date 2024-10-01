package com.ponsun.pep.spouse.spouseFather.services;

import com.ponsun.pep.spouse.spouseFather.domain.SpouseFather;
import com.ponsun.pep.spouse.spouseFather.domain.SpouseFatherRepository;
import com.ponsun.pep.spouse.spouseFather.domain.SpouseFatherRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpouseFatherReadPlatformServiceIml implements SpouseFatherReadPlatformService {
    private final SpouseFatherRepositoryWrapper spouseFatherRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final SpouseFatherRepository spouseFatherRepository;

    @Override
    public SpouseFather fetchSpouseFatherById(Integer id){

        return this.spouseFatherRepository.findById(id).get();

    }
    @Override
    public List<SpouseFather> fetchAllSpouseFather(){
        return this.spouseFatherRepository.findAll();
    }
}
