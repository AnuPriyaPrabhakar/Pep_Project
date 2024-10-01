package com.ponsun.pep.searchLifcycle.searchResult.domain;

import com.ponsun.pep.searchLifcycle.searchResult.request.AbstractSearchResultBaseRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchResultRepositoryWrapperResult extends AbstractSearchResultBaseRequest {

    private final SearchResultRepository searchResultRepository;
    @Transactional
    public SearchResult findOneWithNotFoundDetection(final Integer id){
        return  this.searchResultRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PepSearch Not found " + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
