package com.ponsun.pep.getDirectors.domain;

import com.ponsun.pep.getDirectors.request.AbstractGetDirectorsRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetDirectorsWrapper extends AbstractGetDirectorsRequest {
    private final GetDirectorsRepository getDirectorsRepository;
    @Transactional
    public GetDirectors findOneWithNotFoundDetection(final Integer id){
        return this.getDirectorsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Director Name Not found "+id));
    }
    @Override
    public String toString() { return  super.toString();}
}
