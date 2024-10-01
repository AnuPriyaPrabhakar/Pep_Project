package com.ponsun.pep.pepDetails.Customer.rowmapper;

import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.master.Country.data.CountryData;
import com.ponsun.pep.pepDetails.Customer.data.CustomerData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<CustomerData> {
    private final String schema;

    public CustomerRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_customer pc ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ccc.id as id");
        builder.append("ccc.name as name");
        builder.append("ccc.sourceLink as sourceLink");
//        builder.append("ccc.gender as gender");
        builder.append("ccc.genderId as genderId");
        builder.append("ccc.education as education");
        builder.append("ccc.placeOfBirth as placeOfBirth");
        builder.append("ccc.dob as dob");
        builder.append("ccc.pan as pan");
        builder.append("ccc.directorsIdentificationNumber as directorsIdentificationNumber");
        builder.append("ccc.adverseInformation sa adverseInformation");
        builder.append("ccc.uid as uid");
        builder.append("ccc.euid as euid");
        builder.append("ccc.qcViewDt as qcViewDt");
        builder.append("ccc.qcEditDt as qcEditDt");
        builder.append("ccc.manageraApproveDt as managerApproveDt");
        builder.append("ccc.qcPendingDt as qcPendingDt");
        builder.append("ccc.publishedDt as publishedDt");
        builder.append("ccc.managerPendingDt as managerPendingDt");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public CustomerData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final String sourceLink = rs.getString("sourceLink");
//        final String gender = rs.getString("gender");
        final Integer genderId = rs.getInt("genderId");
        final String education = rs.getString("education");
        final String placeOfBirth = rs.getString("placeOfBirth");
        final String dob = rs.getString("dob");
        final String pan = rs.getString("pan");
        final String directorsIdentificationNumber = rs.getString("directorsIdentificationNumber");
        final Integer adverseInformation = rs.getInt("adverseInformation");
        final Integer regulatoryAction = rs.getInt("regulatoryAction");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        final String qcViewDt = rs.getString("qcViewDt");
        final String qcEditDt = rs.getString("qcEditDt");
        final String manageraApproveDt = rs.getString("manageraApproveDt");
        final String qcPendingDt = rs.getString("qcPendingDt");
        final String publishedDt = rs.getString("publishedDt");
        final String managerPendingDt = rs.getString("managerPendingDt");
        return new CustomerData(id,name,sourceLink,genderId,education,placeOfBirth,dob,pan,directorsIdentificationNumber,adverseInformation,regulatoryAction,uid,euid,qcViewDt,qcEditDt,manageraApproveDt,qcPendingDt,publishedDt,managerPendingDt);
    }
}
