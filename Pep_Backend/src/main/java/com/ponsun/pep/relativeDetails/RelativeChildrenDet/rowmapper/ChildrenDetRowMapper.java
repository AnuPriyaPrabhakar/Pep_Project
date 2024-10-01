package com.ponsun.pep.relativeDetails.RelativeChildrenDet.rowmapper;

import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeChildrenDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class ChildrenDetRowMapper implements RowMapper<RelativeChildrenDTO> {

    private final String schema;
    public ChildrenDetRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_relative_det_children rdc");
        this.schema = builder.toString();
    }


    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("rdc.pepId as pepId, ");
        builder.append("rdc.relativeDetId as relativeDetId, ");
        builder.append("rdc.relativeId as relativeId, ");
        builder.append("rdc.childrenName as childrenName, ");
        builder.append("rdc.pan as pan, ");
        builder.append("rdc.uid as uid, ");
        builder.append("rdc.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override

    public RelativeChildrenDTO mapRow (ResultSet rs , int rowNum) throws SQLException {
        final Integer pepId = rs.getInt("pepId");
        final Integer relativeId = rs.getInt("relativeId");
        final Integer relativeDetId = rs.getInt("relativeDetId");
        final String childrenName = rs.getString("childrenName");
        final String pan = rs.getString("pan");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new RelativeChildrenDTO(pepId , relativeDetId , relativeId ,childrenName , pan,uid,euid);
    }
}
