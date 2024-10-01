package com.ponsun.pep.master.designation.rowmapper;


import com.ponsun.pep.master.designation.data.DesignationData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DesignationRowMapper implements RowMapper<DesignationData> {

    private final String schema;

    public DesignationRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_Config_Designation ccd ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ccd.id as id");
        builder.append("ccd.name as name,");
        builder.append("ccd.dt as dt,");

        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public DesignationData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name= rs.getString("name");
        return new DesignationData(id,name);
    }
}
