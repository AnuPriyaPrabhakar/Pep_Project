package com.ponsun.pep.searchLifcycle.RemarkDetails.rowmapper;

import com.ponsun.pep.searchLifcycle.RemarkDetails.data.RemarkDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class RemarkDetailsRowmapper implements RowMapper<RemarkDetailsData> {
    public final String schema;

    public RemarkDetailsRowmapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM hitrecord_lifecycle ");
        this.schema = builder.toString();
    }
    public String schema(){return this.schema;}
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("DATE (created_at) AS created_At,level_id,remark ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public RemarkDetailsData mapRow(ResultSet rs,int rowNum) throws SQLException{
        final Integer levelId = rs.getInt("level_id");
//        final Integer hitdataId = rs.getInt("hitdata_id");
        final String remark = rs.getString("remark");
        final String createdAt= rs.getString("created_At");
        return RemarkDetailsData.newInstance(levelId,remark,createdAt);
    }
}
