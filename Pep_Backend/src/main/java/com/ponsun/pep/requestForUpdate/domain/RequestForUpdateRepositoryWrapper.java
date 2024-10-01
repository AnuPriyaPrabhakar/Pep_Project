package com.ponsun.pep.requestForUpdate.domain;

import com.ponsun.pep.requestForUpdate.request.AbstractRequestForUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RequestForUpdateRepositoryWrapper extends AbstractRequestForUpdateRequest {


    private final RequestForUpdateRepository requestForUpdateRepository;
    @Transactional
    public RequestForUpdate findOneWithNotFoundDetection(final Integer id) {
        return this.requestForUpdateRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("RequestForUpdate Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
