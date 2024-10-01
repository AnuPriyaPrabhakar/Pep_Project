package com.ponsun.pep.familyDetails.FatherDetails.rowmapper;

import com.ponsun.pep.familyDetails.FamilyCommonService.dto.FatherDTO;
import com.ponsun.pep.familyDetails.FatherDetails.data.FatherDetailsData;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class FatherDetailsRowMapper implements RowMapper<FatherDTO> {
    private final String schema;

    public FatherDetailsRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_father father ");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("father.pepId as pepId,");
        builder.append("father.fatherName as fatherName,");
        builder.append("father.fatherPan as fatherPan,");
        builder.append("father.uid as uid,");
        builder.append("father.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public FatherDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer pepId = rs.getInt("pepId");
        final String fatherName = rs.getString("fatherName");
        final String fatherPan = rs.getString("fatherPan");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new FatherDTO(pepId,fatherName,fatherPan,uid,euid);
    }
}
