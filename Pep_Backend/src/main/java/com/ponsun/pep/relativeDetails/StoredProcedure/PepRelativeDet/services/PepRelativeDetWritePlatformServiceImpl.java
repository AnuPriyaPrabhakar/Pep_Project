package com.ponsun.pep.relativeDetails.StoredProcedure.PepRelativeDet.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PepRelativeDetWritePlatformServiceImpl implements PepRelativeDetWritePlatformService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    @Override
    public String insertPepRelativeDet(Integer pepId, Integer relativeMasterId, String allMemberDet, Integer ipCreatedBy) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("insert_PepRelativeDet");
//                .declareParameters(
//                    new SqlParameter("pep_id", Types.INTEGER),
//                    new SqlParameter("relativeMasterId", Types.INTEGER),
//                    new SqlParameter("_AllMemberDet", Types.VARCHAR),
//                    new SqlParameter("ip_created_by", Types.INTEGER));
//                    new SqlOutParameter("total", Types.INTEGER));

        Map<String, Object> out = simpleJdbcCall.execute(
                new MapSqlParameterSource("pep_id", pepId)
                        .addValue("relativeMasterId", relativeMasterId)
                        .addValue("_AllMemberDet", allMemberDet)
                        .addValue("ip_created_by", ipCreatedBy)
        );
        return out.toString();

//        String storedProcedureCall = "CALL insert_PepRelativeDet(?, ?, ?, ?)";
//        try {
//
//            jdbcTemplate.update(storedProcedureCall, pepId, relativeMasterId, allMemberDet, ipCreatedBy);
//            return "SUCCESS";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "ERROR";
//        }
    }
}













