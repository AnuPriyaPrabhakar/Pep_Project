package com.ponsun.pep.master.gender.rowmapper;



import com.ponsun.pep.master.gender.data.GenderData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GenderRowMapper implements RowMapper<GenderData> {

    private final String schema;

    public GenderRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_config_gender gender ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("gender.id as id, ");
        builder.append("gender.gender as gender, ");
        builder.append("gender.valid as valid, ");
        builder.append(this.schema);
        return builder.toString();
    }


    @Override
    public GenderData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String gender = rs.getString("gender");
        final Boolean valid = rs.getBoolean("valid");
        return GenderData.newInstance(id, gender, valid);
    }
}
