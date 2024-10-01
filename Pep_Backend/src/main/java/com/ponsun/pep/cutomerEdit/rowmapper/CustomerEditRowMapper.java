package com.ponsun.pep.cutomerEdit.rowmapper;

import com.ponsun.pep.cutomerEdit.data.CustomerEditData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j

public class CustomerEditRowMapper implements RowMapper <CustomerEditData>{

    private final String schema;
    public CustomerEditRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_customer a, admin_users b  ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.uid AS uid, a.id AS pepId, b.full_name AS userName, NAME AS pepName, a.dob AS dob, pan AS panNum, sourceLink AS sourceLink, a.created_at AS created_at, (SELECT IFNULL(fatherName, 'Unknown') FROM pep_father WHERE pepId = a.id LIMIT 1) AS fatherName ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public  CustomerEditData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer pepId = rs.getInt("pepId");
        final String userName = rs.getString("userName");
        final String pepName = rs.getString("pepName");
        final String dob = rs.getString("dob");
        final String panNum = rs.getString("panNum");
        final String sourceLink = rs.getString("sourceLink");
        final String uid =rs.getString("uid");
        final String created_at =rs.getString("created_at");
//        final String uid = rs.getString("uid");
        final String frmDate = "";//rs.getString("frmDate");
        final String toDate = "";//rs.getString("toDate");
        final String fatherName =rs.getString("fatherName");
        return new CustomerEditData(pepId , userName ,pepName ,  dob ,panNum , sourceLink , frmDate , toDate,uid , created_at,fatherName);
    }
}
