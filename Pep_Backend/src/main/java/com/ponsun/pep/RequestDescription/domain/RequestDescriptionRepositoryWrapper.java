package com.ponsun.pep.RequestDescription.domain;

import com.ponsun.pep.RequestDescription.request.AbstractRequestDescriptionRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RequestDescriptionRepositoryWrapper extends AbstractRequestDescriptionRequest {
    private final RequestDescriptionRepository requestDescriptionRepository;
    @Transactional
    public RequestDescription findOneWithNotFoundDetection(final Integer id){
        return this.requestDescriptionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Request Description Not found " + id));
    }
    @Override
    public String toString() { return super.toString();}
}
