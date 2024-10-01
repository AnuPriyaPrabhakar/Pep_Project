package com.ponsun.pep.Edit.Manager.services;


import com.ponsun.pep.Edit.Manager.data.QcManagerData;
import com.ponsun.pep.Edit.Manager.rowmaper.QcManagerRowMapper;
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
public class QcManagerWritePlatformServiceImpl implements QcManagerWritePlatformService {
    private final JdbcTemplate jdbcTemplate;
    private final QcManagerRowMapper qcManagerRowMapper;

    @Override
    public List<QcManagerData> fetchAllQcManagerData(String fromDate, String toDate) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fromDate",fromDate);
        parameters.put("toDate",toDate);
        final QcManagerRowMapper rowMapper = new QcManagerRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.pepId=b.id AND a.status='A' AND manager_view=1 AND manager_approve=1";
        Qry = Qry + whereClause;
        final List<QcManagerData> qcManagerData  = jdbcTemplate.query(Qry,qcManagerRowMapper,
                new Object[] {}
        );
        return qcManagerData;
    }
}
