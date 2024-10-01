
package com.ponsun.pep.pepDetails.OtherAssociation.rowmapper;

import com.ponsun.pep.pepDetails.OtherAssociation.data.OtherAssociationData;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OtherAssociationRowMapper implements RowMapper<OtherAssociationData> {
    private final String schema;

    public OtherAssociationRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_other_association oa");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("oa.id as id, ");
        builder.append("oa.pepId as pepId, ");
        builder.append("oa.otherAssociationAsPerMedia as otherAssociationAsPerMedia, ");
        builder.append("oa.uid as uid, ");
        builder.append("oa.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public OtherAssociationData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer pepId = rs.getInt("pepId");
        final String otherAssociationAsPerMedia = rs.getString("otherAssociationAsPerMedia");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new OtherAssociationData(id, pepId, otherAssociationAsPerMedia, uid, euid);
    }
}