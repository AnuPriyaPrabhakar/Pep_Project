package com.ponsun.pep.relativeDetails.Relative.services;

import com.ponsun.pep.relativeDetails.Relative.data.RelativeData;
import com.ponsun.pep.relativeDetails.Relative.domain.Relative;
import com.ponsun.pep.relativeDetails.Relative.domain.RelativeRepository;
import com.ponsun.pep.relativeDetails.Relative.domain.RelativeRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RelativeReadPlatformServiceImpl implements RelativeReadPlatformService {

    private final RelativeRepositoryWrapper relativeRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RelativeRepository relativeRepository;

    @Override
    public List<RelativeData> fetchRelativeByPepId(Integer pepId){
        return this.relativeRepository.findByPepId(pepId);
    }
    @Override
    public List<Relative> fetchAllRelative(){
        return this.relativeRepository.findAll();
        }
}
