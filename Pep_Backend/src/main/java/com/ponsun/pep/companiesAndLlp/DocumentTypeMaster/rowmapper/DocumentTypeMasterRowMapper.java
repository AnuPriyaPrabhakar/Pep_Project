package com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.rowmapper;
import com.ponsun.pep.companiesAndLlp.DocumentTypeMaster.data.DocumentTypeMasterData;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class DocumentTypeMasterRowMapper implements RowMapper<DocumentTypeMasterData> {


    private final String schema;
    public DocumentTypeMasterRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_config_attached_proof pap ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pap.name as name,");
        builder.append("pap.uid as uid,");
        builder.append("pap.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public DocumentTypeMasterData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String name = rs.getString("name");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return DocumentTypeMasterData.newInstance(name,uid,euid);

    }
}
