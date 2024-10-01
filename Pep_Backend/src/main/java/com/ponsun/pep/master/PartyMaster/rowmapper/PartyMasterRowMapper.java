package com.ponsun.pep.master.PartyMaster.rowmapper;

import com.ponsun.pep.master.PartyMaster.data.PartyMasterData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartyMasterRowMapper implements RowMapper<PartyMasterData> {

    private final String schema;

    public PartyMasterRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_config_party pcp ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pcp.id as id");
        builder.append("pcp.partyName as partyName");
        builder.append("cs.uid as uid");
        builder.append("cs.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public PartyMasterData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String partyName = rs.getString("partyName");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new PartyMasterData(partyName, uid, euid);
    }
}
