package com.ponsun.pep.spouse.spouseHuf.rowmapper;

import com.ponsun.pep.spouse.SpouseCommonService.dto.SpouseHufDTO;
import com.ponsun.pep.spouse.spouseHuf.data.SpouseHufData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class SpouseHufRowMapper implements RowMapper<SpouseHufDTO> {
    private final String schema;
    public SpouseHufRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_spouse_huf sh ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
       builder.append("sh.id as id ,");
       builder.append("sh.pepId as pepId , ");
       builder.append("sh.spouseId as spouseId , ");
       builder.append("sh.hufName as hufName , ");
       builder.append("sh.hufPan as hufPan , ");
       builder.append("sh.uid as uid , ");
       builder.append("sh.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public SpouseHufDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer pepId = rs.getInt("pepId");
        final Integer spouseId = rs.getInt("spouseId");
        final String hufName = rs.getString("hufName");
        final String hufPan = rs.getString("hufPan");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new SpouseHufDTO(id,pepId,spouseId,hufName,hufPan,uid,euid);
    }
}

