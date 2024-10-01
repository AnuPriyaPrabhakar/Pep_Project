package com.ponsun.pep.relativeDetails.FamilyDocuments.rowmapper;


import com.ponsun.pep.relativeDetails.FamilyDocuments.data.FamilyDocumentsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class FamilyDocumentsRowMapper implements RowMapper<FamilyDocumentsData> {

    private final String schema;

    public FamilyDocumentsRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_document_family family ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("family.documentType as documentType");
        builder.append("family.pepId as pepId");
        builder.append("family.pathId as pathId");
        builder.append("family.relativeMasterId as relativeMasterId");
        builder.append("family.documentCount as documentCount");
        builder.append("family.documentNameList as documentNameList");
        builder.append("family.uid as uid");
        builder.append("family.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public FamilyDocumentsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String documentType = rs.getString("documentType");
        final Integer pepId = rs.getInt("pepId");
        final Integer pathId = rs.getInt("pathId");
        final Integer relativeMasterId = rs.getInt("relativeMasterId");
        final Integer documentCount = rs.getInt("documentCount");
        final String documentNameList = rs.getString("documentNameList");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new FamilyDocumentsData(documentType,pepId,pathId,relativeMasterId,documentCount,documentNameList,uid,euid);
    }

}
