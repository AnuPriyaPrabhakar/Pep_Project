package com.ponsun.pep.pepDetails.AkaDet.rowmapper;

import com.ponsun.pep.pepDetails.AkaDet.data.AkaDetData;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AkaDetRowmapper implements RowMapper<AkaDetData> {
    private final String schema;

    public AkaDetRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_aka_det pad ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pad.id as id,");
        builder.append("pad.pepId as pepId,");
        builder.append("pad.akaName as akaName,");
        builder.append("pad.uid as uid,");
        builder.append("pad.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AkaDetData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer pepId = rs.getInt("pepId");
        final String akaName = rs.getString("akaName");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");

        return AkaDetData.newInstance(id,pepId,akaName,uid,euid);
        //return new AkaDetData(id,pepId,akaName);
    }

}
