package com.ponsun.pep.customerDetails.services;


import com.ponsun.pep.customerDetails.data.CustomerDetailsData;
import com.ponsun.pep.customerDetails.rowmaper.CustomerDetailsRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerDetailsWritePlatformServiceImpl implements CustomerDetailsWritePlatformService {
    private final JdbcTemplate jdbcTemplate;
    private final CustomerDetailsRowMapper customerDetailsRowMapper;

    @Override
    public  List<CustomerDetailsData> fetchAllCustomerDetailsData() {
        final CustomerDetailsRowMapper rowMapper = new CustomerDetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE STATUS='A' AND NAME IS NOT NULL";
        Qry = Qry + whereClause;
        final List<CustomerDetailsData> customerDetailsData = jdbcTemplate.query(Qry, customerDetailsRowMapper,
                new Object[] {}
        );
        return customerDetailsData;
    }
}
