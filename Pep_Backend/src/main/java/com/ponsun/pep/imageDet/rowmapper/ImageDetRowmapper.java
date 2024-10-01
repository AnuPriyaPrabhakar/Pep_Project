package com.ponsun.pep.imageDet.rowmapper;

import com.ponsun.pep.imageDet.data.ImageDetData;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageDetRowmapper implements RowMapper<ImageDetData> {
    private final String schema;
    public ImageDetRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_image_det pi ");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pi.id as id");
        builder.append("pi.pepId as pepId");
        builder.append("pi.imageName as imageName");
        builder.append("pi.file_type as file_type");
        builder.append("pi.imageMasterId as imageMasterId");
        builder.append("pi.uid as uid");
        builder.append("pi.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public ImageDetData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer pepId = rs.getInt("pepId");
        final String imageName = rs.getString("imageName");
        final String file_type = rs.getString("file_type");
        final Integer imageMasterId = rs.getInt("imageMasterId");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new ImageDetData(id,pepId,imageName,file_type,imageMasterId,uid,euid);
    }
}
