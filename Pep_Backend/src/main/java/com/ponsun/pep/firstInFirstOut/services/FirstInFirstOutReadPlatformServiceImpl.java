package com.ponsun.pep.firstInFirstOut.services;

import com.ponsun.pep.firstInFirstOut.data.FirstInFirstOutData;
import com.ponsun.pep.firstInFirstOut.rowmapper.FirstInFirstOutRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class FirstInFirstOutReadPlatformServiceImpl implements FirstInFirstOutReadPlatformService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<FirstInFirstOutData> getAllCustomersOrderedByIdDesc() {
        String sql = "SELECT * FROM pep_customer ORDER BY id DESC";
        return jdbcTemplate.query(sql, new FirstInFirstOutRowMapper());
    }
}

