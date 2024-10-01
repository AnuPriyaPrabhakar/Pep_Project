package com.ponsun.pep.categoryCommon.All.services;
import com.ponsun.pep.categoryCommon.All.data.AllData;
import com.ponsun.pep.categoryCommon.All.rowmapper.AllRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor

public class AllWritePlatFormServiceImpl implements AllWritePlatFormService {

    private final AllRowMapper allRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<AllData> fetchAllAllData(String pepName) {
        final AllRowMapper rowMapper = new AllRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.id AND a.uid=c.id AND a.directorsIdentificationNumber=f.din AND f.id=e.directorId AND d.id=e.companyId  AND a.name = ? AND a.status = 'A'";
        Qry = Qry + whereClause;
        final List<AllData> allData = jdbcTemplate.query(Qry, allRowMapper,
                new Object[]{pepName}
        );
        return allData;
    }
}
