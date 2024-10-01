package com.ponsun.pep.pepIdentitfier.Indentitfier.rowmapper;

import com.ponsun.pep.pepIdentitfier.Indentitfier.data.IdentifierData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class IdentifierRowMapper implements RowMapper<IdentifierData> {
    private final String schema;
    public IdentifierRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
            builder.append(" FROM (SELECT pepId,NAME,Identity,who FROM (" );
            builder.append(" SELECT id AS pepId,NAME AS NAME,pan AS Identity,'customer' AS who FROM pep_customer WHERE STATUS='A'" );
            builder.append(" UNION" );
            builder.append(" SELECT pepId AS pepId,akaName AS NAME,'' AS Identity,'aka' AS who FROM pep_aka_det WHERE STATUS='A'" );
            builder.append(" UNION" );
            builder.append(" SELECT pepId AS pepId,relativeName AS NAME,pan AS Identity,'relative' AS who FROM pep_relative WHERE STATUS='A'" );
            builder.append(" UNION" );
            builder.append(" SELECT pepId AS pepId,NAME AS NAME,pan AS Identity,'relative_det' AS who FROM pep_relative_det WHERE STATUS='A'" );
            builder.append(" UNION" );
            builder.append(" SELECT pepId AS pepId,childrenName AS NAME,pan AS Identity,'children' AS who FROM pep_relative_det_children WHERE STATUS='A'" );
            builder.append(" UNION" );
            builder.append(" SELECT NULL AS pepId ,companyName AS NAME,CINFCRN AS Identity,'companies' AS who FROM pep_associated_companies WHERE STATUS='A'" );
            builder.append(" UNION" );
            builder.append(" SELECT NULL AS pepId , NAME AS NAME,din AS Identity,'directors' AS who FROM pep_config_companies_directors WHERE STATUS='A'" );
            builder.append(" ) a GROUP BY 2,1) a,pep_customer b" );
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.pepId AS pepId,a.name AS name,b.name AS pepName,a.Identity as identity,a.who as who,b.sourceLink as sourceLink,dob as dob");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public IdentifierData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer pepId = rs.getInt("pepId");
        final String  name = rs.getString("name");
        final String  pepName = rs.getString("pepName");
        final String  identity = rs.getString("identity");
        final String  who = rs.getString("who");
        final String  sourceLink = rs.getString("sourceLink");
        final String  dob = rs.getString("dob");
        return IdentifierData.newInstance(pepId,name,pepName,identity,who,sourceLink,dob);
    }
}
