package com.ponsun.pep.searchLifcycle.HitRecord.rowmapper;

import com.ponsun.pep.searchLifcycle.HitRecord.data.HitRecordData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
public class HitRecordRowMapper implements RowMapper<HitRecordData> {
    private final String schema;

    public HitRecordRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM hitrecord hr ");
        this.schema = builder.toString();
    }
    public String schema() { return this.schema;}

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("hr.id as id, ");
        builder.append("hr.searchId as searchId, ");
        builder.append("hr.display as display, ");
        builder.append("hr.criminalId as criminalId, ");
        builder.append("hr.matchingScore as matchingScore, ");
        builder.append("hr.name as name, ");
        builder.append("hr.statusNowId as statusNowId, ");
        builder.append("hr.cycleId as cycleId, ");
        builder.append("hr.uid as uid, ");
        builder.append("hr.valid as valid ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public HitRecordData mapRow(ResultSet rs,int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer searchId = rs.getInt("searchId");
        final String display = rs.getString("display");
        final Integer criminalId = rs.getInt("criminalId");
        final Double matchingScore = rs.getDouble("matchingScore");
        final String name = rs.getString("name");
        final Integer statusNowId = rs.getInt("statusNowId");
        final Integer cycleId = rs.getInt("cycleId");
        final Long uid = rs.getLong("uid");
        final Boolean valid = rs.getBoolean("valid");
        return HitRecordData.newInstance(id,searchId,display,criminalId,matchingScore,name,statusNowId,cycleId,uid,valid);
    }
}
