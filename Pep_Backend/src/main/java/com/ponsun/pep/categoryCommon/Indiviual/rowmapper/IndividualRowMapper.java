package com.ponsun.pep.categoryCommon.Indiviual.rowmapper;

import com.ponsun.pep.categoryCommon.Indiviual.data.IndividualData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@Service
@Slf4j
public class IndividualRowMapper implements RowMapper<IndividualData> {

    private final String schema;
    public IndividualRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_customer a , category b , admin_users c  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id AS pepId , c.full_name AS userName , a.name AS pepName,a.sourceLink AS SourceLink,a.education AS Education,a.pan AS PepPan,a.dob AS PepDob");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public IndividualData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer pepId = rs.getInt("pepId");
        final String userName = rs.getString("userName");
        final String pepName = rs.getString("pepName");
        final String SourceLink = rs.getString("SourceLink");
        final String Education = rs.getString("Education");
        final String PepPan = rs.getString("PepPan");
        final String PepDob = rs.getString("PepDob");
        return IndividualData.newInstance(pepId,userName,pepName,SourceLink,Education,PepPan,PepDob);
    }
}
