package com.ponsun.pep.master.Country.rowmapper;

import com.ponsun.pep.master.Country.data.CountryData;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<CountryData> {
    private final String schema;
    public CountryRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM crm_config_country ccc ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
       builder.append("ccc.id as id");
       builder.append("ccc.name as name");
       builder.append("ccc.uid as uid");
       builder.append("ccc.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public CountryData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CountryData(id,name,uid,euid);
    }
}

