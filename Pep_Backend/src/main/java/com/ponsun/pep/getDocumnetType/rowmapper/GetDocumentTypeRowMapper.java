package com.ponsun.pep.getDocumnetType.rowmapper;

import com.ponsun.pep.getDocumnetType.data.GetDocumentTypeData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class GetDocumentTypeRowMapper implements RowMapper<GetDocumentTypeData> {

    private final String schema;
    public GetDocumentTypeRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_document_companies");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" companyId,pathId,CONCAT(id) AS documentType,CONCAT(url, '\\\\',id, '.', documentType) AS concatenated");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public GetDocumentTypeData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer companyId = rs.getInt("companyId");
        final Integer pathId = rs.getInt("pathId");
        final String documentType = rs.getString("documentType");
        final String concatenated = rs.getString("concatenated");
        return GetDocumentTypeData.newInstance(companyId,pathId,documentType,concatenated);
    }
}
