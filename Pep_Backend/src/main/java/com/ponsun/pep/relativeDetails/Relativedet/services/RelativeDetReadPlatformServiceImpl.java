package com.ponsun.pep.relativeDetails.Relativedet.services;


import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDet;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDetRepository;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDetRepositoryWrapper;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDetDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RelativeDetReadPlatformServiceImpl implements RelativeDetReadPlatformService {

    private final RelativeDetRepositoryWrapper relativeDetRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RelativeDetRepository relativeDetRepository;

@Override
    public RelativeDet fetchRelativeDetById(Integer id){
       return this.relativeDetRepository.findById(id).get();
}

@Override
    public List<RelativeDet> fetchAllRelativeDet(){
    return this.relativeDetRepository.findAll();}


    public List<RelativeDetDTO> fetchRelativeDetDTO(int relativeId) {
        // Fetch details specific to the provided relativeId
        return relativeDetRepository.findByRelativeId(relativeId);
    }
}
