package com.ponsun.pep.reports.CreatedAt.rowmapper;

import com.ponsun.pep.reports.CreatedAt.data.CreatedAtData;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class CreatedAtRowMapper implements RowMapper<CreatedAtData> {

    private final String schema;
    public CreatedAtRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_customer a, admin_users b  ");
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
    public CreatedAtData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String name = rs.getString("name");
        final Integer count = rs.getInt("count");
        final String frmDate = "";//rs.getString("frmDate");
        final String toDate = "";//rs.getString("toDate");
        return CreatedAtData.newInstance(name,count,frmDate,toDate);
    }
}


