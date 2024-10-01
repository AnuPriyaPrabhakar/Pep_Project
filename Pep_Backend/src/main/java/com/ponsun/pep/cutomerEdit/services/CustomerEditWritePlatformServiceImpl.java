package com.ponsun.pep.cutomerEdit.services;
import com.ponsun.pep.cutomerEdit.data.CustomerEditData;
import com.ponsun.pep.cutomerEdit.rowmapper.CustomerEditRowMapper;
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
public class CustomerEditWritePlatformServiceImpl implements  CustomerEditWritePlatformService {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerEditRowMapper customerEditRowMapper;
    @Override
    public List<CustomerEditData> fetchAllCustomerEditData(String frmDate, String toDate ) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("frmDate", frmDate);
        parameters.put("toDate", toDate);
        final CustomerEditRowMapper rowMapper = new CustomerEditRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.uid=b.id AND DATE(a.created_at) BETWEEN ? AND ? AND a.status='A' ";
        Qry = Qry + whereClause;
        final List<CustomerEditData> customerEditData = jdbcTemplate.query(Qry,customerEditRowMapper,
                new Object[] {frmDate,toDate}
        );
        return customerEditData;
    }
}
