package com.ponsun.pep.taskAssignView.services;

import com.ponsun.pep.taskAssignView.data.TaskAssignViewData;
import com.ponsun.pep.taskAssignView.rowmapper.TaskAssignViewRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskAssignViewWritePlatformServiceImpl implements TaskAssignViewWritePlatformService {
    private final JdbcTemplate jdbcTemplate;
    private final TaskAssignViewRowMapper taskAssignViewRowMapper;
    @Override
    public List<TaskAssignViewData> fetchAllTaskAssignViewData(){
       final TaskAssignViewRowMapper rowMapper = new TaskAssignViewRowMapper();
       String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.assignTo=b.id AND c.id=a.stateId AND d.id=a.countryId";
        Qry = Qry + whereClause;
        final List<TaskAssignViewData> TaskAssignViewData = jdbcTemplate.query(Qry,taskAssignViewRowMapper);
       return TaskAssignViewData;
    }
}
