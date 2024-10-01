package com.ponsun.pep.getCompanyName.services;

import com.ponsun.pep.getCompanyName.data.GetCompanyNameData;
import com.ponsun.pep.getCompanyName.rowmapper.GetCompanyNameRowmapper;
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
public class GetCompanyNameWritePlatformServiceImpl implements GetCompanyNameWritePlatformService{
    private final JdbcTemplate jdbcTemplate;
    private final GetCompanyNameRowmapper getCompanyNameRowmapper;


    @Override
    public Integer getCompanyId(String CINFCRN){

        String query = "SELECT a.id FROM pep_associated_companies a WHERE a.CINFCRN = ? AND a.status = 'A' ORDER BY a.id DESC LIMIT 1";

        Integer getCompanyNameId = jdbcTemplate.queryForObject(query, new Object[]{CINFCRN}, Integer.class);
        return getCompanyNameId;
    }

    @Override
    public List<GetCompanyNameData> fetchAllGetCompanyNameData( String companyName) {

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("companyName", companyName);


        final GetCompanyNameRowmapper rowMapper = new GetCompanyNameRowmapper();

        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.companyName='"+companyName+"' AND a.status='A' ORDER BY a.id DESC LIMIT 1";
        Qry = Qry + whereClause;
        final List<GetCompanyNameData> getCompanyNameData = jdbcTemplate.query(Qry,getCompanyNameRowmapper,
                new Object[] {}
        );

        return getCompanyNameData;
    }
}
