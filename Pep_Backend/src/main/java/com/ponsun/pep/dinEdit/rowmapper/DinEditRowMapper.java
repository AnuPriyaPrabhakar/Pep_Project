package com.ponsun.pep.dinEdit.rowmapper;

import com.ponsun.pep.dinEdit.data.DinEditData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class DinEditRowMapper implements RowMapper<DinEditData> {
    private final String schema;

    public DinEditRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_config_companies_directors cd");
        this.schema = builder.toString();
    }

    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cd.id as id, ");
        builder.append("cd.name as name, ");
        builder.append("cd.din as din, ");
        builder.append("cd.uid as uid ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public DinEditData mapRow(ResultSet rs,int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final String din = rs.getString("din");
        final Integer uid = rs.getInt("uid");
        return new DinEditData(id,name,din,uid);
    }

}
