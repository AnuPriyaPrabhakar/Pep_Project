package com.ponsun.pep.taskAssign.services;

import com.ponsun.pep.taskAssign.domain.TaskAssign;
import com.ponsun.pep.taskAssign.domain.TaskAssignRepository;
import com.ponsun.pep.taskAssign.domain.TaskAssignRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class TaskAssignReadPlatformServiceImpl implements TaskAssignReadPlatformService{
    private final TaskAssignRepository taskAssignRepository;
    private final JdbcTemplate jdbcTemplate;
    private final TaskAssignRepositoryWrapper taskAssignRepositoryWrapper;

    @Override
    public TaskAssign fetchTaskAssignById(Integer id){ return this.taskAssignRepository.findById(id).get();}

    @Override
    public List<TaskAssign> fetchAllTaskAssign(){ return this.taskAssignRepository.findAll();}
}
