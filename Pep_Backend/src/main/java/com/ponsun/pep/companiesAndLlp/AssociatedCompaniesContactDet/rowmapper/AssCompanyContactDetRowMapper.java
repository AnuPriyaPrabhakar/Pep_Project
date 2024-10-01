package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.rowmapper;

import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyContactDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class AssCompanyContactDetRowMapper implements RowMapper<CompanyContactDTO> {

    private final String schema;

    public AssCompanyContactDetRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_asscompanies_contact_det cd ");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cd.companyId, cd.emailID, cd.uid, cd.euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public CompanyContactDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer companyId = rs.getInt("companyId");
        final String emailID = rs.getString("emailID");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CompanyContactDTO( companyId,emailID,uid,euid);
    }
}
