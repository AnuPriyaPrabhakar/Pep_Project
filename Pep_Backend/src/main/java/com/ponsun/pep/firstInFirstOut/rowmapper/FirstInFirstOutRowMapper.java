package com.ponsun.pep.firstInFirstOut.rowmapper;


import com.ponsun.pep.firstInFirstOut.data.FirstInFirstOutData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class FirstInFirstOutRowMapper implements RowMapper<FirstInFirstOutData> {
    private final String schema;
    public FirstInFirstOutRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_customer pc ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ccc.id as id");
        builder.append("ccc.name as name");
        builder.append("ccc.sourceLink as sourceLink");
        builder.append("ccc.education as education");
        builder.append("ccc.dob as dob");
        builder.append("ccc.pan as pan");
        builder.append("ccc.directorsIdentificationNumber as directorsIdentificationNumber");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public FirstInFirstOutData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final String sourceLink = rs.getString("sourceLink");
        final String education = rs.getString("education");
        final String dob = rs.getString("dob");
        final String pan = rs.getString("pan");
        final String directorsIdentificationNumber = rs.getString("directorsIdentificationNumber");
        return new FirstInFirstOutData(id,name,sourceLink,education,dob,pan,directorsIdentificationNumber);
    }
}
