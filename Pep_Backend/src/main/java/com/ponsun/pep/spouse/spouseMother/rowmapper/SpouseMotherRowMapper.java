package com.ponsun.pep.spouse.spouseMother.rowmapper;

import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseMotherDTO;
import com.ponsun.pep.spouse.spouseMother.data.SpouseMotherData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class SpouseMotherRowMapper implements RowMapper<SpouseMotherDTO> {
    private final String schema;
    public SpouseMotherRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_spouse_mother sm ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
       builder.append("sm.id as id ,");
       builder.append("sm.pepId as pepId ,");
        builder.append("sm.spouseId as spouseId ,");
       builder.append("sm.motherName as motherName ,");
       builder.append("sm.motherPan as motherPan ,");
       builder.append("sm.uid as uid ,");
       builder.append("sm.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public SpouseMotherDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer pepId = rs.getInt("pepId");
        final Integer spouseId = rs.getInt("spouseId");
        final String motherName = rs.getString("motherName");
        final String motherPan = rs.getString("motherPan");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new SpouseMotherDTO(id,pepId,spouseId,motherName,motherPan,uid,euid);
    }
}

