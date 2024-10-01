package com.ponsun.pep.reports.QcEditDt.services;

import com.ponsun.pep.reports.QcEditDt.data.QcEditDtData;
import com.ponsun.pep.reports.QcEditDt.rowmapper.QcEditDtRowMapper;
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
public class QcEditDtWritePlatformServiceImpl implements  QcEditDtWritePlatformService {


    private final JdbcTemplate jdbcTemplate;
    private final QcEditDtRowMapper qcEditDtRowMapper;

    @Override
    public List<QcEditDtData> fetchAllQcEditDtData(String frmDate, String toDate) {

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("frmDate", frmDate);
        parameters.put("toDate", toDate);

        final QcEditDtRowMapper rowMapper = new QcEditDtRowMapper();

        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE b.id = a.uid AND DATE(a.created_at) BETWEEN ? AND ?";
        Qry = Qry + whereClause;


        final List<QcEditDtData> qcEditDtData = jdbcTemplate.query(Qry, qcEditDtRowMapper,
                new Object[]{frmDate, toDate}
        );

        return qcEditDtData;
    }
}
