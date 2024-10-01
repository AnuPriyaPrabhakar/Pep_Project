package com.ponsun.pep.taskReassign.services;

import com.ponsun.pep.taskReassign.domain.TaskReassign;
import com.ponsun.pep.taskReassign.domain.TaskReassignRepository;
import com.ponsun.pep.taskReassign.domain.TaskReassignRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskReassignReadPlatformServiceImpl implements TaskReassignReadPlatformService {

    private final TaskReassignRepositoryWrapper taskReassignRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final TaskReassignRepository taskReassignRepository;

    @Override
    public TaskReassign fetchTaskReassignById(Integer id) {

        return this.taskReassignRepository.findById(id).get();
    }

    @Override
    public TaskReassign fetchTaskReassignByPepId(Integer pepId) {
        return this.taskReassignRepository.findById(pepId).get();
    }

    @Override
    public List<TaskReassign> fetchAllTaskReassign() {
        return this.taskReassignRepository.findAll();
    }
}

