package com.ponsun.pep.categoryCommon.All.rowmapper;


import com.ponsun.pep.categoryCommon.All.data.AllData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@Service
@Slf4j
public class AllRowMapper implements RowMapper<AllData> {

    private final String schema;
    public AllRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_customer a , category b , admin_users c ,pep_associated_companies d , pep_companies_directors e , pep_config_companies_directors f  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" DISTINCT a.id AS pepId , c.full_name AS userName , a.name AS pepName,a.sourceLink AS SourceLink,a.education AS Education,a.pan AS PepPan,a.dob AS PepDob,d.id AS companyId , d.companyName , d.CINFCRN , d.originalDateOfAppointment , e.appointmentDate , e.cessationDate");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AllData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer pepId = rs.getInt("pepId");
        final String userName = rs.getString("userName");
        final String pepName = rs.getString("pepName");
        final String SourceLink = rs.getString("SourceLink");
        final String Education = rs.getString("Education");
        final String PepPan = rs.getString("PepPan");
        final String PepDob = rs.getString("PepDob");
        final Integer companyId = rs.getInt("companyId");
        final String CompanyName = rs.getString("CompanyName");
        final String CINFCRN = rs.getString("CINFCRN");
        final String originalDateOfAppointment = rs.getString("originalDateOfAppointment");
        final String appointmentDate = rs.getString("appointmentDate");
        final String cessationDate = rs.getString("cessationDate");
        return new AllData(pepId,userName,pepName,SourceLink,Education,PepPan,PepDob,companyId,CompanyName,CINFCRN,originalDateOfAppointment,appointmentDate,cessationDate);
    }
}
