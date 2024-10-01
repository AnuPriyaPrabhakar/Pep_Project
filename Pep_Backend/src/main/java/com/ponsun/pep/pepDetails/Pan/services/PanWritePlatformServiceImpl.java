package com.ponsun.pep.pepDetails.Pan.services;

import com.ponsun.pep.pepDetails.Pan.data.PanData;
import com.ponsun.pep.pepDetails.Pan.rowmapper.PanRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PanWritePlatformServiceImpl implements PanWritePlatformService {
    private final PanRowMapper panRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<PanData> getPan(String pan) {
        // Check if PAN already exists in the database
        if (isPanExists(pan)) {
            // Throw an exception or handle the duplicate PAN error
            throw new RuntimeException("Duplicate PAN found: " + pan);
        }
        // If PAN doesn't exist, proceed with insertion
        final PanRowMapper rowMapper = new PanRowMapper();
        String query = "SELECT " + rowMapper.tableSchema() + " WHERE pan = ?  AND STATUS='A'";
        return jdbcTemplate.query(query, panRowMapper, pan);
    }

    private boolean isPanExists(String pan) {
        String query = "SELECT COUNT(*) FROM pep_customer WHERE pan = ?";
        Integer count = jdbcTemplate.queryForObject(query, Integer.class, pan);
        return count != null && count > 0;
    }
}
