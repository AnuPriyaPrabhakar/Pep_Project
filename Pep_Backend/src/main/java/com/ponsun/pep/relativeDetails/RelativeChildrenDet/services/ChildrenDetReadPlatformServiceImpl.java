package com.ponsun.pep.relativeDetails.RelativeChildrenDet.services;

import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDet;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDetRepository;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDetRepositoryWrapper;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeChildrenDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChildrenDetReadPlatformServiceImpl implements ChildrenDetReadPlatformService {

    private final ChildrenDetRepositoryWrapper childrenDetRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final ChildrenDetRepository childrenDetRepository;


    @Override

    public ChildrenDet fetchChildrenDetById (Integer id) {

        return this.childrenDetRepository.findById(id).get();
    }


    public List<RelativeChildrenDTO> fetchRelativeChildrenDTO(int relativeId) {
            // Fetch children details specific to the provided relativeId
            return childrenDetRepository.findByRelativeId(relativeId);
        }

    @Override
    public List<ChildrenDet> fetchAllChildrenDet(){return this.childrenDetRepository.findAll();}

}
