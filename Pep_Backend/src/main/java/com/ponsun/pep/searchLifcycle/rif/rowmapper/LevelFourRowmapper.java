package com.ponsun.pep.searchLifcycle.rif.rowmapper;

import com.ponsun.pep.searchLifcycle.rif.data.LevelFourData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class LevelFourRowmapper implements RowMapper<LevelFourData> {
    public final String schema;
    public LevelFourRowmapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_search a,hitrecord b,pep_config_country d,pep_config_state e,hitrecord_lifecycle f");
        this.schema = builder.toString();
    }
    public String schema(){ return this.schema;}
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.name AS searchName , a.id AS searchId, b.id AS hitId,f.case_id AS caseId,a.name , b.matchingScore AS MatchScore,d.name AS Country,e.stateName AS State ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public LevelFourData mapRow(ResultSet rs,int rowNum) throws SQLException{
        final Integer searchId = rs.getInt("searchId");
//        final Integer criminalId = rs.getInt("criminalId");
        final Integer hitId = rs.getInt("hitId");
        final Integer caseId = rs.getInt("caseId");
        final String name = rs.getString("name");
        final Integer matchScore = rs.getInt("MatchScore");
        final String country = rs.getString("Country");
        final String state = rs.getString("state");
        final String searchName = rs.getString("searchName");
//        final String dob = rs.getString("dob");
        return LevelFourData.newInstance(searchId,hitId,caseId,name,matchScore,country,state,searchName);
    }
}
