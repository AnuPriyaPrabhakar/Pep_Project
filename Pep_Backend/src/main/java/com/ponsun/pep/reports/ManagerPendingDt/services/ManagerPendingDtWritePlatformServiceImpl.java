package com.ponsun.pep.reports.ManagerPendingDt.services;

import com.ponsun.pep.reports.ManagerPendingDt.data.ManagerPendingDtData;
import com.ponsun.pep.reports.ManagerPendingDt.rowmapper.ManagerPendingDtRowMapper;
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
public class ManagerPendingDtWritePlatformServiceImpl implements ManagerPendingDtWritePlatformService
{

    private final JdbcTemplate jdbcTemplate;
    private final ManagerPendingDtRowMapper managerPendingDtRowMapper;

    @Override
    public List<ManagerPendingDtData> fetchAllManagerPendingDtData(String frmDate, String toDate) {

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("frmDate", frmDate);
        parameters.put("toDate", toDate);

        final ManagerPendingDtRowMapper rowMapper = new ManagerPendingDtRowMapper();

        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE DATE(a.manager_pending_dt) BETWEEN ? AND ?";
        Qry = Qry + whereClause;


        final List<ManagerPendingDtData> managerPendingDtData = jdbcTemplate.query(Qry,managerPendingDtRowMapper,
                new Object[] {frmDate,toDate}
        );

        return managerPendingDtData;
    }
}
