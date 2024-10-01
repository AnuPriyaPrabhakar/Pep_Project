package com.ponsun.pep.RequestDescription.services;

import com.ponsun.pep.RequestDescription.domain.RequestDescription;
import com.ponsun.pep.RequestDescription.domain.RequestDescriptionRepository;
import com.ponsun.pep.RequestDescription.domain.RequestDescriptionRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class RequestDescriptionReadPlatformServiceImpl  implements RequestDescriptionReadPlatformService{
    private final RequestDescriptionRepositoryWrapper requestDescriptionRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RequestDescriptionRepository requestDescriptionRepository;
    @Override
    public RequestDescription fetchRequestDescriptionById(Integer id){
        return this.requestDescriptionRepository.findById(id).get();
    }
    @Override
    public List<RequestDescription> fetchAllRequestDescription() { return this.requestDescriptionRepository.findAll();}
}
