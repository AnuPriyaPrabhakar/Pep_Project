package com.ponsun.pep.reports.ManagerAproveDt.services;

import com.ponsun.pep.reports.ManagerAproveDt.data.ManagerApproveDtData;
import com.ponsun.pep.reports.ManagerAproveDt.rowmapper.ManagerApproveDtRowMapper;
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
public class ManagerApproveDtWritePlatformServiceImpl implements ManagerApproveDtWritePlatformService{

    private final JdbcTemplate jdbcTemplate;
    private final ManagerApproveDtRowMapper managerApproveDtRowMapper;

    @Override
    public List<ManagerApproveDtData> fetchAllManagerApproveDtData(String frmDate, String toDate) {

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("frmDate", frmDate);
        parameters.put("toDate", toDate);

        final ManagerApproveDtRowMapper rowMapper = new ManagerApproveDtRowMapper();

        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE b.id = a.uid AND DATE(a.created_at) BETWEEN ? AND ?";
        Qry = Qry + whereClause;


        final List<ManagerApproveDtData> managerApproveDtData = jdbcTemplate.query(Qry,managerApproveDtRowMapper,
                new Object[] {frmDate,toDate}
        );

        return managerApproveDtData;
    }
}
