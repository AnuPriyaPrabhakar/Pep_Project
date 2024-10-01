package com.ponsun.pep.Search.domain;

import com.ponsun.pep.Search.request.AbstractSearchRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SearchRepositoryWrapper extends AbstractSearchRequest {
    private final SearchRepository searchRepository;

    @Transactional
    public Search findOneWithNotFoundDetection(final Integer id){
        return this.searchRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Search Not found "+id));
    }
    @Override
    public String toString(){return super.toString();}
}
