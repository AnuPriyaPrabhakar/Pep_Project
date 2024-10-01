package com.ponsun.pep.reports.PublishedDt.rowmapper;

import com.ponsun.pep.reports.PublishedDt.data.PublishedDtData;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class PublishedDtRowMapper implements RowMapper<PublishedDtData> {
    private final String schema;
    public PublishedDtRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_customer a  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("COUNT(a.id) AS COUNT");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public PublishedDtData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer count = rs.getInt("count");
        final String frmDate = "";//rs.getString("frmDate");
        final String toDate = "";//rs.getString("toDate");
        return PublishedDtData.newInstance(count,frmDate,toDate);
    }

}
