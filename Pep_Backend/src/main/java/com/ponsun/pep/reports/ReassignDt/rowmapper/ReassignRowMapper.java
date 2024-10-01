package com.ponsun.pep.reports.ReassignDt.rowmapper;

import com.ponsun.pep.reports.ReassignDt.data.ReassignDtData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class ReassignRowMapper implements RowMapper<ReassignDtData> {
    private final String schema;
    public ReassignRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_task_reassign_status a,admin_users b  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("b.full_name AS NAME, COUNT(a.id) AS COUNT");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ReassignDtData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String name = rs.getString("name");
        final Integer count = rs.getInt("count");
        final String frmDate = "";//rs.getString("frmDate");
        final String toDate = "";//rs.getString("toDate");
        return ReassignDtData.newInstance(name,count,frmDate,toDate);
    }   
}
