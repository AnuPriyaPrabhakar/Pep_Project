package com.ponsun.pep.relativeDetails.Relative.rowmapper;

import com.ponsun.pep.relativeDetails.Relative.data.RelativeData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class RelativeRowmapper implements RowMapper<RelativeData> {
    private final String schema;

    public RelativeRowmapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_relative pr");
        this.schema = builder.toString();
    }

    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" pr.id as id ,");
        builder.append(" pr.pepId as pepId ,");
        builder.append(" pr.relativeMasterId as relativeMasterId ,");
        builder.append(" pr.relativeName as relativeName ,");
        builder.append(" pr.pan as pan ,");
        builder.append(" pr.uid as uid ,");
        builder.append(" pr.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public RelativeData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer pepId = rs.getInt("pepId");
        final Integer relativeMasterId = rs.getInt("relativeMasterId");
        final String relativeName = rs.getString("relativeName");
        final String pan = rs.getString("pan");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new RelativeData(id,pepId,relativeMasterId,relativeName,pan,uid,euid);
    }
}
