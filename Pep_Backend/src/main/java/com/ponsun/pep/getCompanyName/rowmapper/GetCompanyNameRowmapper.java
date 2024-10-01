package com.ponsun.pep.getCompanyName.rowmapper;

import com.ponsun.pep.getCompanyName.data.GetCompanyNameData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class GetCompanyNameRowmapper implements RowMapper<GetCompanyNameData> {

//    SELECT a.companyName FROM pep_associated_companies a ,pep_customer b
//    WHERE a.pepId AND b.id;
    private final String schema;
    public GetCompanyNameRowmapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_associated_companies a");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as associatedId,a.companyName as companyName");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public GetCompanyNameData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String companyName = rs.getString("companyName");
        final Integer associatedId = rs.getInt("associatedId");
        final Integer pepId = 0;//rs.getString("toDate");
        return GetCompanyNameData.newInstance(companyName,associatedId,pepId);
    }
}
