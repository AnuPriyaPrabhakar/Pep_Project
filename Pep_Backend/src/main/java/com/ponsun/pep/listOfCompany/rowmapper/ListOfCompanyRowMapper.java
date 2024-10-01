package com.ponsun.pep.listOfCompany.rowmapper;

import com.ponsun.pep.listOfCompany.data.ListOfCompanyData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListOfCompanyRowMapper implements RowMapper<ListOfCompanyData> {
    private final String schema;
    public ListOfCompanyRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_list_of_company lc");
        this.schema = builder.toString();
    }
    public  String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("lc.id as id");
        builder.append("lc.type as type");
        builder.append("lc.uid as uid");
        builder.append("lc.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public ListOfCompanyData mapRow(ResultSet rs,int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final String type = rs.getString("type");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new ListOfCompanyData(id,type,uid,euid);
    }
}
