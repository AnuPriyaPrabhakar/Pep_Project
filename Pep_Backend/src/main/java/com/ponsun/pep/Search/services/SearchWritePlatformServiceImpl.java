package com.ponsun.pep.Search.services;

import com.ponsun.pep.Search.data.SearchData;
import com.ponsun.pep.Search.data.SearchDataValidator;
import com.ponsun.pep.Search.domain.SearchRepositoryWrapper;
import com.ponsun.pep.Search.domain.Search;
import com.ponsun.pep.Search.domain.SearchRepository;
import com.ponsun.pep.Search.request.CreateSearchRequest;
import com.ponsun.pep.Search.rowmapper.SearchRowMapper;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class SearchWritePlatformServiceImpl implements SearchWritePlatformService {
    private final SearchRepository searchRepository;
    private final SearchRepositoryWrapper searchReportRepositoryWrapper;
    private final SearchDataValidator searchDataValidator;
    private final JdbcTemplate jdbcTemplate;
    private final SearchRowMapper searchRowMapper;


    @Transactional
    public Response createSearch(CreateSearchRequest createSearchRequest){
        try{
            this.searchDataValidator.validateSaveSearch(createSearchRequest);
            Search search = Search.create(createSearchRequest);
            search = this.searchRepository.saveAndFlush(search);
            return new Response(search.getId());
        }catch(DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @jakarta.transaction.Transactional
    public List<SearchData> fetchAll() {
        final SearchRowMapper rowMapper = new SearchRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause =" WHERE ps.status='A'  ORDER BY ps.id DESC";
        Qry = Qry + whereClause;
        final List<SearchData> searchDataList = jdbcTemplate.query(Qry, searchRowMapper,
                new Object[] {}
        );
        return searchDataList;
    }
}
