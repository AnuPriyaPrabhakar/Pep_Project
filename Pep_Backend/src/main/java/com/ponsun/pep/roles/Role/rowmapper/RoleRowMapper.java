package com.ponsun.pep.roles.Role.rowmapper;

import com.ponsun.pep.roles.Role.data.RoleData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
@Slf4j
@RequiredArgsConstructor

public class RoleRowMapper implements RowMapper<RoleData> {

    private final String schema;
    public RoleRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_role pr ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pr.id AS id ,");
        builder.append("pr.role_name AS roleName ,");
        builder.append("pr.uid AS uid ,");
        builder.append("pr.euid AS euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public RoleData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String roleName = rs.getString("roleName");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new RoleData(roleName,uid,euid);
    }
}
