package com.ponsun.pep.getDocumnetType.services;

import com.ponsun.pep.getDocumnetType.data.GetDocumentTypeData;
import com.ponsun.pep.getDocumnetType.rowmapper.GetDocumentTypeRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetDocumentTypeReadPlatformServiceImpl implements  GetDocumentTypeReadPlatformService{

    private final JdbcTemplate jdbcTemplate;
    private final GetDocumentTypeRowMapper getDocumentTypeRowMapper;

    @Override
    public List<GetDocumentTypeData> getDocumentType(Integer companyId, Integer pathId) {
        final GetDocumentTypeRowMapper rowMapper = new GetDocumentTypeRowMapper();

        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE companyId = ? AND pathId = ? AND STATUS='A'";
        Qry = Qry + whereClause;
        final List<GetDocumentTypeData> getDocumentTypeDataList = jdbcTemplate.query(Qry,getDocumentTypeRowMapper,
                new Object[] {companyId,pathId}
        );
        return getDocumentTypeDataList;
    }
}