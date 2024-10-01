package com.ponsun.pep.master.RelativeConfig.rowmapper;


import com.ponsun.pep.master.RelativeConfig.data.RelativeConfigData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RelativeRowMapper implements RowMapper<RelativeConfigData> {
    private final String schema;

    public RelativeRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM crm_config_relative ccr ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ccr.id as id");
        builder.append("ccr.name as name");
        builder.append("ccr.uid as uid");
        builder.append("ccr.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public RelativeConfigData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new RelativeConfigData(id,name,uid,euid);
    }
}


