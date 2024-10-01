package com.ponsun.pep.searchLifcycle.ScreeningSearch.rowmapper;

import com.ponsun.pep.searchLifcycle.ScreeningSearch.data.ScreeningSearchData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class ScreeningSearchRowMapper implements RowMapper<ScreeningSearchData> {
    private final String schema;
    public ScreeningSearchRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_search ");
        this.schema = builder.toString();
    }
    public String schema(){return this.schema;}

    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("id,NAME ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public ScreeningSearchData mapRow(ResultSet rs,int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final Integer kycId = 0;
        return ScreeningSearchData.newInstance(id,name,kycId);
    }

}
