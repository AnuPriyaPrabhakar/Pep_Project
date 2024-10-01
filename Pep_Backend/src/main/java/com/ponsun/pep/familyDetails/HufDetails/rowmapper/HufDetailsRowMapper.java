package com.ponsun.pep.familyDetails.HufDetails.rowmapper;


import com.ponsun.pep.familyDetails.FamilyCommonService.dto.HufDTO;
import com.ponsun.pep.familyDetails.HufDetails.data.HufDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class HufDetailsRowMapper implements RowMapper<HufDTO> {
    private final String schema;

    public HufDetailsRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_huf ph ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ph.pepId as pepId,");
        builder.append("ph.hufName as hufName,");
        builder.append("ph.hufPan as hufPan,");
        builder.append("ph.uid as uid,");
        builder.append("ph.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public HufDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer pepId = rs.getInt("pepId");
        final String hufName = rs.getString("hufName");
        final String hufPan = rs.getString("hufPan");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new HufDTO(pepId,hufName,hufPan,uid,euid);
    }
}