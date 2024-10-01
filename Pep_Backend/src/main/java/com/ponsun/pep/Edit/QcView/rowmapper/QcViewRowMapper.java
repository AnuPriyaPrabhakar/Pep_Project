package com.ponsun.pep.Edit.QcView.rowmapper;


import com.ponsun.pep.Edit.QcView.data.QcViewData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j

public class QcViewRowMapper implements RowMapper<QcViewData> {
    private final String schema;
    public QcViewRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_task_reassign_status a,pep_customer b  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("b.name AS pepName,b.pan AS pepPan,b.dob AS pepDOB,b.sourceLink AS pepSourceLink ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public QcViewData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String pepName = rs.getString("pepName");
        final String  pepPan = rs.getString("pepPan");
        final String pepDOB = rs.getString("pepDOB");
        final String pepSourceLink = rs.getString("pepSourceLink");
        final String fromDate = "";//rs.getString("fromDate");
        final String toDate = "";//rs.getString("toDate");
        return QcViewData.newInstance(pepName,pepPan,pepDOB,pepSourceLink,fromDate,toDate);
    }
}


