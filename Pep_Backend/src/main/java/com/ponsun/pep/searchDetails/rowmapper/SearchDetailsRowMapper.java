//package com.ponsun.pep.searchDetails.rowmapper;
//
//import com.ponsun.pep.searchDetails.data.SearchDetailsData;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Service;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Data
//@Service
//@Slf4j
//public class SearchDetailsRowMapper implements RowMapper<SearchDetailsData> {
//    private final String schema;
//
//    public SearchDetailsRowMapper(){
//        final StringBuilder builder = new StringBuilder(200);
//        builder.append(" FROM pep_search_details sd");
//        this.schema = builder.toString();
//    }
//
//    public String tableSchema(){
//        final StringBuilder builder = new StringBuilder(200);
//        builder.append("sd.id as id, ");
//        builder.append("sd.searchId as searchId, ");
//        builder.append("sd.name as name, ");
//        builder.append("sd.matchingScore as matchingScore, ");
//        builder.append("sd.uid as uid, ");
//        builder.append("sd.euid as euid , ");
//        builder.append("sd.kycId as kycId ");
//        builder.append(this.schema);
//        return builder.toString();
//    }
//    @Override
//    public SearchDetailsData mapRow(ResultSet rs,int rowNum) throws SQLException{
//        final Integer id = rs.getInt("id");
//        final Integer searchId = rs.getInt("searchId");
//        final String name = rs.getString("name");
//        final Double matchingScore = rs.getDouble("matchingScore");
//        final Integer uid = rs.getInt("uid");
//        final Integer euid = rs.getInt("euid");
//        final String fromDate = "";
//        final String toDate = "";
//        final Integer kycId = rs.getInt("kycId");
//        return SearchDetailsData.newInstance(id,searchId,name,matchingScore,uid,euid,fromDate,toDate,kycId);
//    }
//}


package com.ponsun.pep.searchDetails.rowmapper;

import com.ponsun.pep.searchDetails.data.SearchDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class SearchDetailsRowMapper implements RowMapper<SearchDetailsData> {
    private final String schema;

    public SearchDetailsRowMapper(){
        final  StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_search_details sd");
        this.schema = builder.toString();
    }
    public String schema(){return this.schema;}

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("sd.id as id, ");
        builder.append("sd.euid as euid, ");
        builder.append("sd.searchId as searchId, ");
        builder.append("sd.countryId as countryId, ");
        builder.append("sd.identity as identity, ");
        builder.append("sd.levelId as levelId, ");
        builder.append("sd.listId as listId, ");
        builder.append("sd.matchingScore as matchingScore, ");
        builder.append("sd.name as name, ");
        builder.append("sd.state_id as state_id, ");
        builder.append("sd.type_id as type_id, ");
        builder.append("sd.uid as uid, ");
        builder.append("sd.valid as valid, ");
        builder.append("sd.kycId as kycId ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public SearchDetailsData mapRow(ResultSet cs,int rowNum) throws SQLException{
        final Integer id = cs.getInt("id");
        final Integer euid = cs.getInt("euid");
        final Integer searchId = cs.getInt("searchId");
        final Integer countryId = cs.getInt("countryId");
        final String identity = cs.getString("identity");
        final Long levelId = cs.getLong("levelId");
        final Integer listId = cs.getInt("listId");
        final Double matchingScore = cs.getDouble("matchingScore");
        final String name = cs.getString("name");
        final Integer stateId = cs.getInt("state_id");
        final Integer typeId = cs.getInt("type_id");
        final Integer uid = cs.getInt("uid");
        final Boolean valid = cs.getBoolean("valid");
        final Integer kycId = cs.getInt("kycId");
        return SearchDetailsData.newInstance(id,euid,searchId,countryId,identity,levelId,listId,matchingScore,name,stateId,typeId,uid,valid,kycId);
    }
}
