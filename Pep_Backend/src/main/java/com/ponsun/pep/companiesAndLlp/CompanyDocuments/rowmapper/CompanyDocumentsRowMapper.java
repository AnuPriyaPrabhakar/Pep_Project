package com.ponsun.pep.companiesAndLlp.CompanyDocuments.rowmapper;

import com.ponsun.pep.companiesAndLlp.CompanyDocuments.data.CompanyDocumentsData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDocumentsRowMapper implements RowMapper<CompanyDocumentsData> {

    private final String schema;

    public CompanyDocumentsRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_document_companies company ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("company.id as id ,");
        builder.append("company.companyId as companyId ,");
        builder.append("company.pathId as pathId ,");
        builder.append("company.url as url ,");
        builder.append("company.uid as uid ,");
        builder.append("company.documentType as documentType ,");
        builder.append("company.documentCount as documentCount ,");
        builder.append("company.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public CompanyDocumentsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer companyId = rs.getInt("companyId");
        final Integer pathId = rs.getInt("pathId");
        final String url = rs.getString("url");
        final String documentType = rs.getString("documentType");
        final Integer documentCount = rs.getInt("documentCount");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CompanyDocumentsData(id,companyId,pathId,url,documentType,documentCount,uid,euid);
    }
}
