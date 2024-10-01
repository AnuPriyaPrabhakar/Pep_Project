package com.ponsun.pep.master.AssociatedList.rowmapper;

import com.ponsun.pep.master.AssociatedList.data.AssociatedListData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class AssociatedListRowmapper implements RowMapper<AssociatedListData> {
    private final String schema;

    public AssociatedListRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_config_associated_list pcal ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pcal.id as id");
        builder.append("pcal.name as name");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AssociatedListData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        return new AssociatedListData(id,name);
    }

}
