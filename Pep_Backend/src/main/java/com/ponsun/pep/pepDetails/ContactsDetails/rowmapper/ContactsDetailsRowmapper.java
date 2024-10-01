package com.ponsun.pep.pepDetails.ContactsDetails.rowmapper;

import com.ponsun.pep.pepDetails.ContactsDetails.data.ContactsDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j

public class ContactsDetailsRowmapper implements RowMapper<ContactsDetailsData> {

    private final String schema;

    public ContactsDetailsRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_contacts_details pc ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pc.id as id ,");
        builder.append("pc.contactId as contactId ,");
        builder.append("pc.communicationDt as communicationDt ,");
        builder.append("pc.communicationTypeId as communicationTypeId ,");
        builder.append("pc.uid as uid ,");
        builder.append("pc.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ContactsDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer contactId = rs.getInt("contactId");
        final String communicationDt = rs.getString("communicationDt");
        final Integer communicationTypeId = rs.getInt("communicationTypeId");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new ContactsDetailsData(id,contactId,communicationDt,communicationTypeId,uid,euid);
    }

}
