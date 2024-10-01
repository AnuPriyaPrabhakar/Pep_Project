package com.ponsun.pep.getDirectors.rowmapper;


import com.ponsun.pep.getDirectors.data.GetDirectorsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class GetDirectorsRowMapper implements RowMapper<GetDirectorsData> {

    private final String schema;
    public GetDirectorsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_config_companies_directors a , pep_customer b ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.id AS directorId , a.name AS name , a.din AS din , b.directorsIdentificationNumber , b.pan");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public GetDirectorsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer directorId = rs.getInt("directorId");
        final String name = rs.getString("name");
        final String din = rs.getString("din");
        final String directorsIdentificationNumber = rs.getString("directorsIdentificationNumber");
        final String pan = rs.getString("pan");
        return GetDirectorsData.newInstance(directorId,name,din,directorsIdentificationNumber,pan);
    }
}
