package com.ponsun.pep.reports.TaskAssignReport.rowmapper;

import com.ponsun.pep.reports.TaskAssignReport.data.TaskAssignReportData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class TaskAssignReportRowMapper implements RowMapper <TaskAssignReportData> {
    private final String schema;
    public TaskAssignReportRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_task_assign a,admin_users b,pep_config_state c,pep_config_country d  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("d.name AS country,c.stateName AS state,a.year, b.userName AS uid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public TaskAssignReportData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String country = rs.getString("country");
        final String state = rs.getString("state");
        final String year = rs.getString("year");
        final String uid = rs.getString("uid");
        final String frmDate = "";
        final String toDate = "";
        return TaskAssignReportData.newInstance(country, state, year, uid, frmDate, toDate);
    }

}
