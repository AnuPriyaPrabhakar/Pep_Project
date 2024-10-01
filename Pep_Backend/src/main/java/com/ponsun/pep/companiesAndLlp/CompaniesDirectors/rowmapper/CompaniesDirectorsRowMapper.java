package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.rowmapper;

import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompaniesDirectorsDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class CompaniesDirectorsRowMapper implements RowMapper<CompaniesDirectorsDTO> {
    private final String schema;
    public CompaniesDirectorsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM  pep_companies_directors a, pep_config_companies_directors b, pep_config_designation c, pep_config_company d  ");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.companyId as companyId, ");
        builder.append(" a.directorId as directorId, ");
        builder.append(" a.designationId as designationId, ");
        builder.append(" a.companyMasterId as companyMasterId, ");
        builder.append(" a.appointmentDate as appointmentDate, ");
        builder.append(" a.cessationDate as cessationDate, ");
        builder.append(" b.name as directorName, ");
        builder.append(" b.din as din, ");
        builder.append(" c.name as designation, ");
        builder.append(" d.name as directorStatus, ");
        builder.append(" a.uid as uid, ");
        builder.append(" a.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }


    public CompaniesDirectorsDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer companyId = rs.getInt("companyId");
        final Integer directorId = rs.getInt("directorId");
        final Integer designationId = rs.getInt("designationId");
        final Integer companyMasterId = rs.getInt("companyMasterId");
        final String directorName = rs.getString("directorName");
        final String din    = rs.getString("din");
        final String designation = rs.getString("designation");
        final String directorStatus = rs.getString("directorStatus");
        final String appointmentDate = rs.getString("appointmentDate");
        final String cessationDate = rs.getString("cessationDate");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CompaniesDirectorsDTO(companyId, directorId, directorName, din, designationId, companyMasterId,
                designation, directorStatus, appointmentDate, cessationDate,uid, euid);
    }
}

