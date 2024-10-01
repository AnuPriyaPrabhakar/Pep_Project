package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.rowmapper;

import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyAddressDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class CompaniesAddressRowMapper implements RowMapper<CompanyAddressDTO> {
    private final String schema;
    public CompaniesAddressRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_asscompanies_address_det cd ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cd.id as id, ");
        builder.append("cd.companyId as companyId, ");
        builder.append("cd.registeredAddress as registeredAddress, ");
        builder.append("cd.uid as uid, ");
        builder.append("cd.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public CompanyAddressDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer companyId = rs.getInt("companyId");
        final String  registeredAddress = rs.getString("registeredAddress");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CompanyAddressDTO(id,companyId,registeredAddress,uid,euid);
    }
}
