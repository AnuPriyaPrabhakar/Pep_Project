package com.ponsun.pep.taskAssignView.rowmapper;

import com.ponsun.pep.taskAssignView.data.TaskAssignViewData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class TaskAssignViewRowMapper implements RowMapper<TaskAssignViewData> {
    public final String schema;

    public TaskAssignViewRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_task_assign a,admin_users b,pep_config_state c,pep_config_country d");
        this.schema = builder.toString();
    }
    public String schema(){ return this.schema;}
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("d.name AS country,c.stateName AS state,a.year, b.userName AS uid ");
       builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public TaskAssignViewData mapRow(ResultSet rs,int rowNum) throws SQLException{
        final String country = rs.getString("country");
        final String state = rs.getString("state");
        final String year = rs.getString("year");
        final String uid = rs.getString("uid");
        return TaskAssignViewData.newInstance(country,state,year,uid);
    }
}
