package com.ponsun.pep.relativeDetails.Relativedet.rowmapper;

import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDetDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class RelativeDetRowmapper implements RowMapper<RelativeDetDTO> {

    private final String schema;
    public RelativeDetRowmapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_relative_det prd");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("prd.id as id, ");
        builder.append("prd.name as name, ");
        builder.append("prd.pan as pan, ");
        builder.append("prd.pepId as pepId, ");
        builder.append("prd.relativeId as relativeId, ");
        builder.append("prd.uid as uid, ");
        builder.append("prd.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public RelativeDetDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer pepId = rs.getInt("pepId");
        final Integer relativeId = rs.getInt("relativeId");
        final String name = rs.getString("name");
        final String pan = rs.getString("pan");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new RelativeDetDTO(id,pepId,relativeId,name,pan,uid,euid);

    }

}
