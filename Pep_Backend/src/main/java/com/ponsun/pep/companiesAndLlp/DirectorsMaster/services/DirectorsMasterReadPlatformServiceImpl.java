package com.ponsun.pep.companiesAndLlp.DirectorsMaster.services;


import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMaster;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMasterRepository;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMasterRepositoryWrapper;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.rowmapper.DirectorsMasterRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DirectorsMasterReadPlatformServiceImpl implements  DirectorsMasterReadPlatformService {
    private final DirectorsMasterRepository directorsMasterRepository;
    private final DirectorsMasterRepositoryWrapper directorsMasterRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final DirectorsMasterRowMapper directorsMasterRowMapper;

    @Override
    public DirectorsMaster fetchDirectorsMasterById(Integer id) {
        return this.directorsMasterRepository.findById(id).get();
    }
    @Override
    public List<DirectorsMaster> fetchAllDirectorsMaster() {
        return this.directorsMasterRepository.findAll();
    }
}
