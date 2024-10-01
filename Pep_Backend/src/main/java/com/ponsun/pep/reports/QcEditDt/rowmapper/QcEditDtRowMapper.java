package com.ponsun.pep.reports.QcEditDt.rowmapper;

import com.ponsun.pep.reports.QcEditDt.data.QcEditDtData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j

public class QcEditDtRowMapper  implements RowMapper<QcEditDtData> {
    private final String schema;
    public QcEditDtRowMapper(){
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
    public QcEditDtData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String name = rs.getString("name");
        final Integer count = rs.getInt("count");
        final String frmDate = "";//rs.getString("frmDate");
        final String toDate = "";//rs.getString("toDate");
        return QcEditDtData.newInstance(name,count,frmDate,toDate);
    }
}
