package com.ponsun.pep.reports.PublishedDt.services;

import com.ponsun.pep.reports.PublishedDt.data.PublishedDtData;
import com.ponsun.pep.reports.PublishedDt.rowmapper.PublishedDtRowMapper;
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
public class PublishedDtWritePlatformServiceImpl implements PublishedDtWritePlatformService
    {

        private final JdbcTemplate jdbcTemplate;
        private final PublishedDtRowMapper publishedDtRowMapper;

        @Override
        public List<PublishedDtData> fetchAllPublishedDtData(String frmDate, String toDate) {

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("frmDate", frmDate);
        parameters.put("toDate", toDate);

        final PublishedDtRowMapper rowMapper = new PublishedDtRowMapper();

        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE DATE(a.published_dt) BETWEEN ? AND ?";
        Qry = Qry + whereClause;


        final List<PublishedDtData> managerPendingDtData = jdbcTemplate.query(Qry,publishedDtRowMapper,
                new Object[] {frmDate,toDate}
        );

        return managerPendingDtData;
    }
}
