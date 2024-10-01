package com.ponsun.pep.categoryCommon.Organization.rowmapper;
import com.ponsun.pep.categoryCommon.Organization.data.OrganizationData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class OrganizationRowMapper implements RowMapper<OrganizationData> {

    private final String schema;
    public OrganizationRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_associated_companies a , pep_companies_directors b ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id AS companyId , a.companyName , a.CINFCRN , a.originalDateOfAppointment , b.appointmentDate , b.cessationDate ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public OrganizationData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer companyId = rs.getInt("companyId");
        final String CompanyName = rs.getString("CompanyName");
        final String CINFCRN = rs.getString("CINFCRN");
        final String originalDateOfAppointment = rs.getString("originalDateOfAppointment");
        final String appointmentDate = rs.getString("appointmentDate");
        final String cessationDate = rs.getString("cessationDate");
        return OrganizationData.newInstance(companyId,CompanyName,CINFCRN,originalDateOfAppointment,appointmentDate,cessationDate);
    }
}
