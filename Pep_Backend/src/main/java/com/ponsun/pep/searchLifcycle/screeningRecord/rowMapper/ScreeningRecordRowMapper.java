package com.ponsun.pep.searchLifcycle.screeningRecord.rowMapper;

import com.ponsun.pep.searchLifcycle.screeningRecord.data.ScreeningRecordData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class ScreeningRecordRowMapper implements RowMapper<ScreeningRecordData> {
    private final String schema;

    public ScreeningRecordRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM `pep_search` a,`hitrecord` b ,`pep_customer` c ");
        this.schema = builder.toString();
    }
    public String schema(){return this.schema;}
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("c.name ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public ScreeningRecordData mapRow(ResultSet rs,int rowNum) throws SQLException{
        final String name = rs.getString("name");
        final Integer id = 0;
        return ScreeningRecordData.newInstance(id,name);
    }
}
