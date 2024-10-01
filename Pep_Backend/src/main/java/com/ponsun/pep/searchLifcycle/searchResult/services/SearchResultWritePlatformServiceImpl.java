package com.ponsun.pep.searchLifcycle.searchResult.services;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.searchLifcycle.searchResult.data.SearchResultDataValidator;
import com.ponsun.pep.searchLifcycle.searchResult.domain.SearchResult;
import com.ponsun.pep.searchLifcycle.searchResult.domain.SearchResultRepository;
import com.ponsun.pep.searchLifcycle.searchResult.domain.SearchResultRepositoryWrapperResult;
import com.ponsun.pep.searchLifcycle.searchResult.request.CreateSearchResultRequest;
import com.ponsun.pep.searchLifcycle.searchResult.request.UpdateSearchResultRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchResultWritePlatformServiceImpl implements SearchResultWritePlatformService {
    private final SearchResultRepository searchResultRepository;
    private final SearchResultRepositoryWrapperResult searchResultRepositoryWrapper;
    private final SearchResultDataValidator searchResultDataValidator;

    @Override
    @Transactional
    public Response createSearch(CreateSearchResultRequest createSearchRequest){
        try{
            this.searchResultDataValidator.validateSaveSearchData(createSearchRequest);
            SearchResult searchResult = SearchResult.create(createSearchRequest);
            searchResult = this.searchResultRepository.saveAndFlush(searchResult);
            return Response.of(searchResult.getId());
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateSearch(Integer id, UpdateSearchResultRequest updateSearchRequest){
        try{
            this.searchResultDataValidator.validateUpdateSerachData(updateSearchRequest);
            final SearchResult searchResult = this.searchResultRepositoryWrapper.findOneWithNotFoundDetection(id);
            searchResult.update(updateSearchRequest);
            this.searchResultRepository.saveAndFlush(searchResult);
            return Response.of(Long.valueOf(searchResult.getId()));
        }catch(DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockSearch(Integer id){
        try {
            final SearchResult searchResult = this.searchResultRepositoryWrapper.findOneWithNotFoundDetection(id);
            searchResult.setValid(false);
            searchResult.setStatus(Status.DELETE);
            searchResult.setUpdatedAt(LocalDateTime.now());
            this.searchResultRepository.saveAndFlush(searchResult);
            return Response.of(Long.valueOf(id));
        }catch(DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockSearch(Integer id){
        try{
            final SearchResult searchResult = this.searchResultRepositoryWrapper.findOneWithNotFoundDetection(id);
            searchResult.setValid(true);
            searchResult.setStatus(Status.DELETE);
            searchResult.setUpdatedAt(LocalDateTime.now());
            this.searchResultRepository.saveAndFlush(searchResult);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}