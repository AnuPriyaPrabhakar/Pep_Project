package com.ponsun.pep.taskAssign.rowmapper;

import com.ponsun.pep.taskAssign.data.TaskAssignData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class TaskAssignRowMapper implements RowMapper<TaskAssignData> {
    private final String schema;

    public TaskAssignRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_task_assign ta");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ta.assignTo as assignTo");
        builder.append("ta.assignBy as assignBy");
        builder.append("ta.countryId as countryId");
        builder.append("ta.stateId as stateId");
        builder.append("ta.year as year");
        builder.append("ta.uid as uid");
//        builder.append("ta.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public TaskAssignData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer assignTo = rs.getInt("assignTo");
        final Integer assignBy = rs.getInt("assignBy");
        final Integer countryId = rs.getInt("countryId");
        final Integer stateId = rs.getInt("stateId");
        final Integer year = rs.getInt("year");
        final Integer uid = rs.getInt("uid");
//        final Integer euid = rs.getInt("euid");
        return TaskAssignData.newInstance( assignTo, assignBy, countryId, stateId, year, uid);
    }
}
