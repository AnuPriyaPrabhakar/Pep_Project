package com.ponsun.pep.FilesStorage.rowmapper;

import com.ponsun.pep.FilesStorage.data.FileStorageData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FileStorageRowMapper implements RowMapper<FileStorageData> {


    private final String schema;

    public FileStorageRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_config_attached_proof ccf");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ccf.id as id");
        builder.append("ccf.name as companyId");
        builder.append("ccf.pathId as pathId");
        builder.append("ccf.documentType as documentType");
        builder.append("ccf.updated_at as dt");
        builder.append("ccf.url as url");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public FileStorageData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("companyId");
        final Integer pathId = rs.getInt("pathId");
        final String documentType=rs.getString("documentType");
        final String dt = rs.getString("dt");
        final String url =rs.getString("url");
        return new FileStorageData(id,name,pathId,documentType,dt,url);
    }
}
