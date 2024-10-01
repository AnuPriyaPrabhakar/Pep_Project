package com.ponsun.pep.levelOneRemark.rowmapper;

import com.ponsun.pep.levelOneRemark.data.LevelOneRemarkData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class LevelOneRemarkRowMapper implements RowMapper<LevelOneRemarkData> {
    private final String schema;

    public LevelOneRemarkRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM hitrecord_lifecycle a ,`hitrecord` b,pep_search c");
        this.schema = builder.toString();
    }
    public String schema(){return this.schema;}

    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.id,criminal_id,hitdata_id,a.level_id,remark,search_id,statusId, c.name  AS NAME, b.matchingScore AS score,b.name AS hitName ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public LevelOneRemarkData mapRow(ResultSet rs,int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer criminalId = rs.getInt("criminal_id");
        final Integer hitdataId = rs.getInt("hitdata_id");
        final Integer levelId = rs.getInt("level_id");
        final String remark = rs.getString("remark");
        final Integer searchId = rs.getInt("search_id");
        final Integer statusId = rs.getInt("statusId");
        final String name = rs.getString("name");
        final Integer score=rs.getInt("score");
        final String hitName = rs.getString("hitName");
        return LevelOneRemarkData.newInstance(id,criminalId,hitdataId,levelId,remark,searchId,statusId,name,score,hitName);
    }

}
