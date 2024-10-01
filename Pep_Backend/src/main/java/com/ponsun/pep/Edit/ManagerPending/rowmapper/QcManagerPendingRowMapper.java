package com.ponsun.pep.Edit.ManagerPending.rowmapper;


import com.ponsun.pep.Edit.Manager.data.QcManagerData;
import com.ponsun.pep.Edit.ManagerPending.data.QcManagerPendingData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j

public class QcManagerPendingRowMapper implements RowMapper<QcManagerPendingData> {
    private final String schema;
    public QcManagerPendingRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" From pep_task_reassign_status a,pep_customer b   ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.pepId,b.name AS pepName,b.pan AS panNum,b.dob AS dob,b.sourceLink AS sourceLink  ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public QcManagerPendingData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String pepName = rs.getString("pepName");
        final String  panNum = rs.getString("panNum");
        final String dob = rs.getString("dob");
        final String sourceLink = rs.getString("sourceLink");
        final String fromDate = "";//rs.getString("fromDate");
        final String toDate = "";//rs.getString("toDate");
        final  String pepId =rs.getString("pepId");
        return QcManagerPendingData.newInstance(pepName,panNum,dob,sourceLink,fromDate,toDate,pepId);
    }
}


