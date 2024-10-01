package com.ponsun.pep.companyName.rowmapper;


import com.ponsun.pep.Edit.Manager.data.QcManagerData;
import com.ponsun.pep.companyName.data.CompanyNameData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j

public class CompanyNameRowMapper implements RowMapper<CompanyNameData> {
    private final String schema;
    public CompanyNameRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_associated_companies a ,pep_config_companies_directors b , pep_customer c  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.companyName AS CompanyName ,  ");
        builder.append(" b.din AS din , ");
        builder.append(" c.pan AS pan ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public CompanyNameData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String companyName = rs.getString("companyName");
        final String din = rs.getString("din");
        final String pan = rs.getString("pan");
        return CompanyNameData.newInstance(companyName,din,pan);
    }
}


