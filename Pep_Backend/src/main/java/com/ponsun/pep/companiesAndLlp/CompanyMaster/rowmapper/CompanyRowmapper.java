package com.ponsun.pep.companiesAndLlp.CompanyMaster.rowmapper;

import com.ponsun.pep.companiesAndLlp.CompanyMaster.data.CompanyData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyRowmapper implements RowMapper<CompanyData> {
    private final String schema;
    public CompanyRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_company pcc ");
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
    public CompanyData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CompanyData(id,name,uid,euid);
    }

}
