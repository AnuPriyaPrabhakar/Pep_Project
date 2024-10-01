package com.ponsun.pep.companiesAndLlp.CompanyAssociation.rowmapper;

import com.ponsun.pep.companiesAndLlp.CombinedServices.writeDTO.CompanyAssociationDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class CompanyAssociationRowMapper implements RowMapper<CompanyAssociationDTO> {
    private final String schema;
    public CompanyAssociationRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_company_other_association coa");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("coa.id as id,");
        builder.append("coa.companyId as companyId,");
        builder.append("coa.companyAssociation as companyAssociation,");
        builder.append("coa.uid as uid,");
        builder.append("coa.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public CompanyAssociationDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer companyId = rs.getInt("companyId");
        final String companyAssociation = rs.getString("companyAssociation");
        final Integer uid = rs.getInt("uid");
        final Integer euid =rs.getInt("euid");
        return new CompanyAssociationDTO(id,companyId,companyAssociation,uid,euid);
    }
}
