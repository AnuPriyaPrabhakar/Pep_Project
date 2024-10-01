package com.ponsun.pep.roles.RoleDetails.rowmapper;

import com.ponsun.pep.roles.RoleDetails.data.RoleDetailsData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDetailsRowmapper implements RowMapper<RoleDetailsData> {
    private final String schema;

    public RoleDetailsRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_role_details prd ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("prd.id as id,");
        builder.append("prd.roleId as roleId,");
        builder.append("prd.modId as modId,");
        builder.append("prd.modDetId as modDetId,");
        builder.append("prd.uid as uid,");
        builder.append("prd.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public RoleDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer roleId = rs.getInt("roleId");
        final Integer modId = rs.getInt("modId");
        final Integer modDetId = rs.getInt("modDetId");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");

        return RoleDetailsData.newInstance(id,roleId,modId,modDetId,uid,euid);
    }

}
