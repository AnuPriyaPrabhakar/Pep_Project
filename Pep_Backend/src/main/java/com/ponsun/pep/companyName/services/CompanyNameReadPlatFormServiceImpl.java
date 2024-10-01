package com.ponsun.pep.companyName.services;

import com.ponsun.pep.companyName.data.CompanyNameData;
import com.ponsun.pep.companyName.rowmapper.CompanyNameRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyNameReadPlatFormServiceImpl implements CompanyNameReadPlatFormService {
    private final CompanyNameRowMapper companyNameRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<CompanyNameData> getCompanyName(String din, String pan) {
        final CompanyNameRowMapper rowMapper = new CompanyNameRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE c.pan = ? AND b.din = ? AND a.status = 'A'";
        Qry = Qry + whereClause;
        final List<CompanyNameData> companyNameData  = jdbcTemplate.query(Qry,companyNameRowMapper,
                new Object[] {din,pan}
        );
        return companyNameData;
    }
}
