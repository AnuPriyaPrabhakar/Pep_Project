package com.ponsun.pep.master.District.rowmapper;

import com.ponsun.pep.master.District.data.DistrictData;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DistrictRowMapper implements RowMapper<DistrictData> {
    private final String schema;
    public DistrictRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_config_district dis");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("dis.cityName as cityName");
        builder.append("dis.stateId as stateId");
        builder.append("dis.countryId as countryId");
        builder.append("dis.uid as uid ");
        builder.append("dis.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public DistrictData mapRow (ResultSet rs , int rowNum) throws SQLException {
        final String cityName = rs.getString("cityName");
        final Integer stateId = rs.getInt("stateId");
        final Integer countryId = rs.getInt("countryId");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new DistrictData(cityName , stateId , countryId,uid,euid);
    }
}
