package com.ponsun.pep.master.State.services;

import com.ponsun.pep.master.State.domain.State;
import com.ponsun.pep.master.State.domain.StateRepository;
import com.ponsun.pep.master.State.domain.StateRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StateReadPlatformServiceImpl implements StateReadPlatformService {
    private final StateRepositoryWrapper stateRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final StateRepository stateRepository;
    @Override
    public State fetchStateById(Integer id){
        return this.stateRepository.findById(id).get();
    }
    @Override
    public List<State> fetchAllState(){ return this.stateRepository.findAll();}
}






