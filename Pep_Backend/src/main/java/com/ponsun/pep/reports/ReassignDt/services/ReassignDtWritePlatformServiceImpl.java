package com.ponsun.pep.reports.ReassignDt.services;



import com.ponsun.pep.reports.ReassignDt.data.ReassignDtData;
import com.ponsun.pep.reports.ReassignDt.rowmapper.ReassignRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReassignDtWritePlatformServiceImpl implements ReassignDtWritePlatformService {

    private final JdbcTemplate jdbcTemplate;
    private final ReassignRowMapper reassignRowMapper;

    @Override
    public List<ReassignDtData> fetchAllReassignDtData(String frmDate, String toDate) {

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("frmDate", frmDate);
        parameters.put("toDate", toDate);

        final ReassignRowMapper rowMapper = new ReassignRowMapper();

        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.reassign_to_uid=b.id AND DATE(a.reassign_dt) BETWEEN ? AND ?";
        Qry = Qry + whereClause;


        final List<ReassignDtData> reassignDtData = jdbcTemplate.query(Qry,reassignRowMapper,
                new Object[] {frmDate,toDate}
        );

        return reassignDtData;
    }
}
