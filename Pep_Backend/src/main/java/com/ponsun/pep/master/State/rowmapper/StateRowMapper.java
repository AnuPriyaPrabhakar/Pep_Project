package com.ponsun.pep.master.State.rowmapper;

import com.ponsun.pep.master.State.data.StateData;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StateRowMapper implements RowMapper<StateData> {
    private final String schema;
    public StateRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_config_state cs ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cs.id as id");
        builder.append("cs.countryId as countryId");
        builder.append("cs.stateName as stateName");
        builder.append("cs.uid as uid");
        builder.append("cs.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public StateData mapRow(ResultSet rs,int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer countryId = rs.getInt("countryId");
        final String stateName = rs.getString("stateName");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new StateData(id,countryId,stateName,uid,euid);
    }
}
