package com.ponsun.pep.requestForUpdate.services;

import com.ponsun.pep.requestForUpdate.domain.RequestForUpdate;
import com.ponsun.pep.requestForUpdate.domain.RequestForUpdateRepository;
import com.ponsun.pep.requestForUpdate.domain.RequestForUpdateRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestForUpdateReadPlatformServiceImpl implements RequestForUpdateReadPlatformService{

    private final RequestForUpdateRepositoryWrapper requestForUpdateRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RequestForUpdateRepository requestForUpdateRepository;

    @Override
    public RequestForUpdate fetchRequestForUpdateById(Integer id){
        return this.requestForUpdateRepository.findById(id).get();
    }
    @Override
    public List<RequestForUpdate> fetchAllRequestForUpdate(){
        return this.requestForUpdateRepository.findAll();
    }
}
