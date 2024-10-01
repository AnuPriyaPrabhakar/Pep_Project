package com.ponsun.pep.userTaskView.rowmapper;

import com.ponsun.pep.userTaskView.data.UserTaskViewData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class UserTaskViewRowMapper implements RowMapper<UserTaskViewData> {
    private final String schema;
    public UserTaskViewRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_task_assign a,pep_config_country b,pep_config_state c,admin_users d ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("b.name AS countryName,c.stateName AS stateName,a.year AS YEAR,d.full_name AS manName,a.id AS taskId,b.id AS countryId,c.id AS stateId,a.assignBy AS assignById");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public UserTaskViewData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String countryName = rs.getString("countryName");
        final String stateName = rs.getString("stateName");
        final Integer YEAR = rs.getInt("YEAR");
        final String manName = rs.getString("manName");
        final Integer taskId = rs.getInt("taskId");
        final Integer countryId = rs.getInt("countryId");
        final Integer stateId = rs.getInt("stateId");
        final Integer assignById = rs.getInt("assignById");
        final Integer assignTo = 0;
        return new UserTaskViewData(countryName , stateName ,YEAR ,  manName ,taskId , countryId ,stateId,assignById ,assignTo);

    }
}
