package com.ponsun.pep.RequestDescription.rowmapper;

import com.ponsun.pep.RequestDescription.data.RequestDescriptionData;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestDescriptionRowMapper  implements RowMapper<RequestDescriptionData> {
    private final String schema;

    public RequestDescriptionRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_request_for_update_description ud ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ud.id as id");
        builder.append("ud.pepId as pepId");
        builder.append("ud.description as description");
        builder.append("ud.uid as uid");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public RequestDescriptionData mapRow(ResultSet rs,int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer pepId = rs.getInt("pepId");
        final String description = rs.getString("description");
        final Integer uid = rs.getInt("uid");
        return new RequestDescriptionData(id,pepId,description,uid);
    }
}
