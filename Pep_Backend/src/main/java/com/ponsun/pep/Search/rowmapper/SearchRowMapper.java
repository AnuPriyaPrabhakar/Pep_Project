package com.ponsun.pep.Search.rowmapper;

import com.ponsun.pep.Search.data.SearchData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Data
@Service
@Slf4j
public class SearchRowMapper implements RowMapper<SearchData> {
    private final String schema;

    public SearchRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_search ps LEFT OUTER JOIN admin_users b ON ps.uid = b.id ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }

    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ps.id as id, ");
        builder.append("ps.name as name, ");
        builder.append("ps.searchingScore as searchingScore, ");
        builder.append("ps.matching_score as matching_score ,");
        builder.append("ps.uid as uid, ");
        builder.append("ps.euid as euid, ");
        builder.append("b.userName as userName, ");
        builder.append("ps.created_at as created_at ");

        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public SearchData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final String searchingScore = rs.getString("searchingScore");
        final double matching_score = rs.getDouble("matching_score");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        final String userName = rs.getString("userName");
        final LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();

        final String fromDate = "";
        final String toDate = "";
        return SearchData.newInstance(id,name,searchingScore,matching_score,uid,euid,userName,created_at,fromDate,toDate);
    }
}
