package com.ponsun.pep.familyDetails.MotherDetails.rowmapper;


import com.ponsun.pep.familyDetails.FamilyCommonService.dto.MotherDTO;
import com.ponsun.pep.familyDetails.MotherDetails.data.MotherDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class MotherDetailsRowMapper implements RowMapper<MotherDTO> {
    private final String schema;

    public MotherDetailsRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_mother pm ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pm.pepId as pepId ,");
        builder.append("pm.motherName as motherName ,");
        builder.append("pm.motherPan as motherPan ,");
        builder.append("pm.uid as uid ,");
        builder.append("pm.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public MotherDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer pepId = rs.getInt("pepId");
        final String motherName = rs.getString("motherName");
        final String motherPan = rs.getString("motherPan");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new MotherDTO(pepId,motherName,motherPan,uid,euid);
    }
}