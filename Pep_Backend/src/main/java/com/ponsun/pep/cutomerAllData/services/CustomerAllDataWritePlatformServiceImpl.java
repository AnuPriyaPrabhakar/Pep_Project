package com.ponsun.pep.cutomerAllData.services;
import com.ponsun.pep.cutomerAllData.data.CustomerAllDataData;
import com.ponsun.pep.cutomerAllData.rowmapper.CustomerAllDataRowMapper;
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
public class CustomerAllDataWritePlatformServiceImpl implements CustomerAllDataWritePlatformService {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerAllDataRowMapper customerAllDataRowMapper;

    @Override
    public List<CustomerAllDataData> fetchAllCustomerData() {
        Map<String, Object> parameters = new HashMap<>();
        final CustomerAllDataRowMapper rowMapper = new CustomerAllDataRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.uid=b.id AND a.status='A'";
        Qry = Qry + whereClause;
        final List<CustomerAllDataData> customerAllDataRowMappers = jdbcTemplate.query(Qry,customerAllDataRowMapper);
        return customerAllDataRowMappers;
    }
}
