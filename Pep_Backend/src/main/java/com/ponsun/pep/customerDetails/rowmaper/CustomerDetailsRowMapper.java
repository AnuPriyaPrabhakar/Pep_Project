package com.ponsun.pep.customerDetails.rowmaper;


import com.ponsun.pep.customerDetails.data.CustomerDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class CustomerDetailsRowMapper implements RowMapper<CustomerDetailsData> {
    private final String schema;
    public CustomerDetailsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_customer  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("id as id , name as name , dob as dob , placeOfBirth as placeOfBirth , pan as pan , directorsIdentificationNumber as directorsIdentificationNumber");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public CustomerDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String  name = rs.getString("name");
        final String dob = rs.getString("dob");
        final String placeOfBirth = rs.getString("placeOfBirth");
        final String pan = rs.getString("pan");
        final String directorsIdentificationNumber = rs.getString("directorsIdentificationNumber");
        return CustomerDetailsData.newInstance(id,name,dob,placeOfBirth,pan,directorsIdentificationNumber);
    }
}


