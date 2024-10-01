package com.ponsun.pep.category.rowmapper;

import com.ponsun.pep.category.data.CategoryData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowmapper implements RowMapper<CategoryData> {
    private final String schema;
    public CategoryRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_config_category pcc ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pcc.id as id");
        builder.append("pcc.name as name");
        builder.append("pcc.uid as uid");
        builder.append("pcc.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public CategoryData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CategoryData(id,name,uid,euid);
    }
}
