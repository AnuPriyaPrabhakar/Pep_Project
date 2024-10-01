package com.ponsun.pep.master.RelativeConfig.services;

import com.ponsun.pep.master.RelativeConfig.domain.RelativeConfig;
import com.ponsun.pep.master.RelativeConfig.domain.RelativeConfigRepository;
import com.ponsun.pep.master.RelativeConfig.domain.RelativeConfigRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RelativeConfigReadPlatformServiceImpl implements RelativeConfigReadPlatformService {
    private final RelativeConfigRepositoryWrapper relativeConfigRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RelativeConfigRepository relativeConfigRepository;

    @Override
    public RelativeConfig fetchRelativeById(Integer id){

        return this.relativeConfigRepository.findById(id).get();

    }
    @Override
    public List<RelativeConfig> fetchAllRelative(){
        return this.relativeConfigRepository.findAll();
    }

}
