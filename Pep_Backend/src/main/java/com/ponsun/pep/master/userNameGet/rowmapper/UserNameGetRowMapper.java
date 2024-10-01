package com.ponsun.pep.master.userNameGet.rowmapper;



import com.ponsun.pep.master.userNameGet.data.UserNameGetData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j

public class UserNameGetRowMapper implements RowMapper<UserNameGetData> {
    private final String schema;
    public UserNameGetRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM admin_users a  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.full_name AS fullName ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public UserNameGetData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String fullName = rs.getString("full_name");
        return new UserNameGetData(fullName);
    }
}


