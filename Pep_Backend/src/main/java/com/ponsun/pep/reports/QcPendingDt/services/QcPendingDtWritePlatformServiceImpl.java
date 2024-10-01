package com.ponsun.pep.reports.QcPendingDt.services;


import com.ponsun.pep.reports.QcPendingDt.data.QcPendingDtData;
import com.ponsun.pep.reports.QcPendingDt.rowmapper.QcPendingDtRowMapper;
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
public class QcPendingDtWritePlatformServiceImpl implements QcPendingDtWritePlatformService {


    private final JdbcTemplate jdbcTemplate;
    private final QcPendingDtRowMapper qcPendingDtRowMapper;

    @Override
    public List<QcPendingDtData> fetchAllQcPendingDtData(String frmDate, String toDate) {

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("frmDate", frmDate);
        parameters.put("toDate", toDate);

        final QcPendingDtRowMapper rowMapper = new QcPendingDtRowMapper();

        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE DATE(a.qc_pending_dt) BETWEEN ? AND ?";
        Qry = Qry + whereClause;


        final List<QcPendingDtData> qcPendingDtData = jdbcTemplate.query(Qry,qcPendingDtRowMapper,
                new Object[] {frmDate,toDate}
        );

        return qcPendingDtData;
    }
}
