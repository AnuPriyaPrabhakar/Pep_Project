package com.ponsun.pep.spouse.spouseDetails.rowmapper;


import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseDetailsDTO;
import com.ponsun.pep.spouse.spouseDetails.data.SpouseDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class SpouseDetailsRowMapper implements RowMapper<SpouseDetailsDTO> {
    private final String schema;

    public SpouseDetailsRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_spouse ps ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ps.id as id ,");
        builder.append("ps.pepId as pepId ,");
        builder.append("ps.spouseName as spouseName ,");
        builder.append("ps.spousePan as spousePan ,");
        builder.append("ps.uid as uid ,");
        builder.append("ps.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public SpouseDetailsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer pepId = rs.getInt("pepId");
        final String spouseName = rs.getString("spouseName");
        final String spousePan = rs.getString("spousePan");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new SpouseDetailsDTO(id,pepId,spouseName,spousePan,uid,euid);
    }
}