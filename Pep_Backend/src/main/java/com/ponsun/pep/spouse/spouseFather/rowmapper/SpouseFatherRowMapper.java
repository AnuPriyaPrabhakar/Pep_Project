package com.ponsun.pep.spouse.spouseFather.rowmapper;

import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseFatherDTO;
import com.ponsun.pep.spouse.spouseFather.data.SpouseFatherData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class SpouseFatherRowMapper implements RowMapper<SpouseFatherDTO> {
    private final String schema;
    public SpouseFatherRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_spouse_father sf ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
       builder.append("sf.id as id ,");
       builder.append("sf.pepId as pepId ,");
       builder.append("sf.spouseId as spouseId ,");
       builder.append("sf.fatherName as fatherName ,");
       builder.append("sf.fatherPan as fatherPan ,");
       builder.append("sf.uid as uid ,");
       builder.append("sf.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public SpouseFatherDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer pepId = rs.getInt("pepId");
        final Integer spouseId = rs.getInt("spouseId");
        final String fatherName = rs.getString("fatherName");
        final String fatherPan = rs.getString("fatherPan");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new SpouseFatherDTO(id,pepId,spouseId,fatherName,fatherPan,uid,euid);
    }
}

