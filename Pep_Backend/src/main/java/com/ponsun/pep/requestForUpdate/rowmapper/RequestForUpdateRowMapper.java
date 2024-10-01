package com.ponsun.pep.requestForUpdate.rowmapper;

import com.ponsun.pep.requestForUpdate.data.RequestForUpdateData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@Service
@Slf4j
public class RequestForUpdateRowMapper implements RowMapper <RequestForUpdateData> {

    private final String schema;

    public RequestForUpdateRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_request_for_update request");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("request.pepId as pepId, ");
        builder.append("request.requestAt as requestAt, ");
        builder.append("request.requestUid as requestUid, ");
        builder.append("request.updatedUid as updatedUid, ");
        builder.append("request.valid as valid, ");
        builder.append("request.updated as updated, ");
        builder.append("request.requestForUpdate as requestForUpdate");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public RequestForUpdateData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer pepId = rs.getInt("pepId");
        final String requestAt = rs.getString("requestAt");
        final Integer requestUid = rs.getInt("requestUid");
        final Integer updatedUid = rs.getInt("updatedUid");
        final Integer valid = rs.getInt("valid");
        final String updated = rs.getString("updated");
        final String requestForUpdate = rs.getString("requestForUpdate");
        return RequestForUpdateData.newInstance(pepId,requestAt,requestUid,updatedUid,valid,updated,requestForUpdate);
    }
}
