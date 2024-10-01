package com.ponsun.pep.companiesAndLlp.DirectorsMaster.rowmapper;

import com.ponsun.pep.companiesAndLlp.DirectorsMaster.data.DirectorsMasterData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class DirectorsMasterRowMapper implements RowMapper<DirectorsMasterData> {
    private final String schema;
    public DirectorsMasterRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_companies_directors pcd ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pad.name as name,");
        builder.append("pad.din as din,");
        builder.append("pad.uid as uid,");
        builder.append("pad.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public DirectorsMasterData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String name = rs.getString("name");
        final String din = rs.getString("din");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return DirectorsMasterData.newInstance(name,din,uid,euid);

    }
}
