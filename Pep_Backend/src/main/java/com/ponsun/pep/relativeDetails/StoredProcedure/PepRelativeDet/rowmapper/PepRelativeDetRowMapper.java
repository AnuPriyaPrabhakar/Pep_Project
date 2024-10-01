package com.ponsun.pep.relativeDetails.StoredProcedure.PepRelativeDet.rowmapper;

import com.ponsun.pep.relativeDetails.StoredProcedure.PepRelativeDet.data.PepRelativeDetData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class PepRelativeDetRowMapper implements RowMapper<PepRelativeDetData> {
    @Override
    public PepRelativeDetData mapRow(ResultSet rs, int rowNum) throws SQLException {
        PepRelativeDetData pepRelativeDetData = new PepRelativeDetData();
        pepRelativeDetData.setPepId(rs.getInt("pep_id"));
        pepRelativeDetData.setRelativeMasterId(rs.getInt("relative_master_id"));
        pepRelativeDetData.setAllMemberDet(rs.getString("all_member_det"));
        pepRelativeDetData.setIpCreatedBy(rs.getInt("ip_created_by"));
        return pepRelativeDetData;
    }
}
