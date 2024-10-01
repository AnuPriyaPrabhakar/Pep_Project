package com.ponsun.pep.companiesAndLlp.AssociatedCompanies.rowmapper;

import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.data.AssociatedCompaniesData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class AssociatedCompaniesRowMapper implements RowMapper<AssociatedCompaniesData> {
    private final String schema;

    public AssociatedCompaniesRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_customer a,pep_config_companies_directors b,pep_associated_companies c,pep_companies_directors d  ");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("d.id AS directorId , c.id , c.companyName , c.sourceLink,c.listAdverseInformation,c.listRegulatoryAction,c.listGovernment,c.typeId, c.associateMasterId , c.CINFCRN ,  c.originalDateOfAppointment , c.uid , c.euid ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AssociatedCompaniesData mapRow(ResultSet rs,int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer directorId = rs.getInt("directorId");
        final String companyName = rs.getString("companyName");
        final Integer associateMasterId = rs.getInt("associateMasterId");
        final String sourceLink = rs.getString("sourceLink");
        final String CINFCRN = rs.getString("CINFCRN");
        final String originalDateOfAppointment = rs.getString("originalDateOfAppointment");
        final Integer listAdverseInformation = rs.getInt("listAdverseInformation");
        final Integer listRegulatoryAction = rs.getInt("listRegulatoryAction");
        final Integer listGovernment = rs.getInt("listGovernment");
        final Integer typeId = rs.getInt("typeId");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new AssociatedCompaniesData(id,directorId,companyName, associateMasterId,sourceLink,CINFCRN, originalDateOfAppointment,listAdverseInformation, listRegulatoryAction, listGovernment,typeId,uid,euid);
    }
}
