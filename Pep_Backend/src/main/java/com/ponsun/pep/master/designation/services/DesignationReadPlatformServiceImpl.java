package com.ponsun.pep.master.designation.services;


import com.ponsun.pep.master.designation.domain.Designation;
import com.ponsun.pep.master.designation.domain.DesignationRepository;
import com.ponsun.pep.master.designation.domain.DesignationRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DesignationReadPlatformServiceImpl implements DesignationReadPlatformService {
    private final DesignationRepositoryWrapper designationRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final DesignationRepository designationRepository;

    @Override
    public Designation fetchDesignationById(Integer id) {
        return this.designationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Designation> fetchAllDesignation() {
        return this.designationRepository.findAll();
    }
}
