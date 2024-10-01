package com.ponsun.pep.master.CompanyMaster.rowmapper;

import com.ponsun.pep.master.CompanyMaster.data.CompanyMasterData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMasterRowMapper implements RowMapper<CompanyMasterData> {
    private final String schema;
    public CompanyMasterRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_config_company pcc ");
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
    public CompanyMasterData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CompanyMasterData(id,name,uid,euid);
    }

}
