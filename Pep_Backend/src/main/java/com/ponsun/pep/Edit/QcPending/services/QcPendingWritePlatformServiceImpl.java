package com.ponsun.pep.Edit.QcPending.services;


import com.ponsun.pep.Edit.QcPending.data.QcPendingData;
import com.ponsun.pep.Edit.QcPending.rowmaper.QcPendingRowMapper;

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
public class QcPendingWritePlatformServiceImpl implements QcPendingWritePlatformService {
    private final JdbcTemplate jdbcTemplate;
    private final QcPendingRowMapper qcPendingRowMapper;

    @Override
    public List<QcPendingData> fetchAllQcPendingData( String fromDate, String toDate) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fromDate",fromDate);
        parameters.put("toDate",toDate);

        final QcPendingRowMapper rowMapper = new QcPendingRowMapper();

        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.pepId=b.id AND a.status='A' AND qc_approved=0 AND qc_pending=1";
        Qry = Qry + whereClause;


        final List<QcPendingData> qcPendingData   = jdbcTemplate.query(Qry,qcPendingRowMapper,
                new Object[] {}
        );

        return qcPendingData;
    }
}
