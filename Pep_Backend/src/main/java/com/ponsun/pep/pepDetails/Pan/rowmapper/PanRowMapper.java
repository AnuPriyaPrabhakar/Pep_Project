
package com.ponsun.pep.pepDetails.Pan.rowmapper;
import com.ponsun.pep.pepDetails.Pan.data.PanData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j

public class PanRowMapper implements RowMapper<PanData> {
    private final String schema;
    public PanRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_customer  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" pan AS pan ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public PanData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String pan = rs.getString("pan");
        return PanData.newInstance(pan);
    }
}


