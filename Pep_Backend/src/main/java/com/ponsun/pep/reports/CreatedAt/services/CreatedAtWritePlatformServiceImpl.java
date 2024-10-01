package com.ponsun.pep.reports.CreatedAt.services;


import com.ponsun.pep.reports.CreatedAt.data.CreatedAtData;
import com.ponsun.pep.reports.CreatedAt.rowmapper.CreatedAtRowMapper;
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
public class CreatedAtWritePlatformServiceImpl implements CreatedAtWritePlatformService {
    private final JdbcTemplate jdbcTemplate;
    private final CreatedAtRowMapper createdAtRowMapper;

    @Override
    public List<CreatedAtData> fetchAllCreatedAtData(String frmDate, String toDate) {

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("frmDate", frmDate);
        parameters.put("toDate", toDate);

        final CreatedAtRowMapper rowMapper = new CreatedAtRowMapper();

        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE b.id = a.uid AND DATE(a.created_at) BETWEEN ? AND ?";
        Qry = Qry + whereClause;


        final List<CreatedAtData> createdAtData = jdbcTemplate.query(Qry,createdAtRowMapper,
                new Object[] {frmDate,toDate}
        );

        return createdAtData;
    }
}
