package com.ponsun.pep.bulkTaskAssignView.rowmapper;




import com.ponsun.pep.bulkTaskAssignView.data.BulkTaskAssignViewData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class BulkTaskAssignViewRowMapper implements RowMapper<BulkTaskAssignViewData> {

    private final String schema;

    public BulkTaskAssignViewRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM pep_bulk_task_assign a,admin_users b ");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" b.id AS uid, a.searchName , b.userName AS userName  ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public BulkTaskAssignViewData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer uid = rs.getInt("uid");
        final String searchName = rs.getString("searchName");
        final String userName = rs.getString("userName");
        return new BulkTaskAssignViewData(uid , searchName , userName);
    }
}