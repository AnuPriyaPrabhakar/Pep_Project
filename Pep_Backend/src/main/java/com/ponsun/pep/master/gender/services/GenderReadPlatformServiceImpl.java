package com.ponsun.pep.master.gender.services;


import com.ponsun.pep.master.gender.domain.Gender;
import com.ponsun.pep.master.gender.domain.GenderRepository;
import com.ponsun.pep.master.gender.domain.GenderRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenderReadPlatformServiceImpl implements GenderReadPlatformService {

    private final GenderRepositoryWrapper genderRepositoryWrapper;

    private final JdbcTemplate jdbcTemplate;

    private final GenderRepository genderRepository;

    @Override
    public Gender fetchGenderById(Integer id) {
        return this.genderRepository.findById(id).get();
    }

    @Override
    public List<Gender> fetchAllGender() {
        return this.genderRepository.findAll();
    }

}
