package com.ponsun.pep.categoryCommon.Organization.services;
import com.ponsun.pep.categoryCommon.Organization.data.OrganizationData;
import com.ponsun.pep.categoryCommon.Organization.rowmapper.OrganizationRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class OrganizationRedPlatformServiceImpl implements OrganizationRedPlatformService {

    private final OrganizationRowMapper organizationRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<OrganizationData> fetchAllOrganizationData(String companyName) {
        final OrganizationRowMapper rowMapper = new OrganizationRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.id = b.id AND companyName = ?";
        Qry = Qry + whereClause;
        final List<OrganizationData> organizationData = jdbcTemplate.query(Qry, organizationRowMapper,
                new Object[]{companyName}
        );
        return organizationData;
    }
}
