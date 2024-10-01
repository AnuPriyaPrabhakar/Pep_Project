package com.ponsun.pep.reports.ManagerPendingDt.rowmapper;
import com.ponsun.pep.reports.ManagerPendingDt.data.ManagerPendingDtData;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class ManagerPendingDtRowMapper implements RowMapper<ManagerPendingDtData> {

    private final String schema;
    public ManagerPendingDtRowMapper(){
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
    public ManagerPendingDtData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer count = rs.getInt("count");
        final String frmDate = "";//rs.getString("frmDate");
        final String toDate = "";//rs.getString("toDate");
        return ManagerPendingDtData.newInstance(count,frmDate,toDate);
    }
}
