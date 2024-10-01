package com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class DirectorsMasterRepositoryWrapper {
    private final DirectorsMasterRepository directorsMasterRepository;

    @Transactional
    public DirectorsMaster findOneWithNotFoundDetection(final Integer id) {
        return this.directorsMasterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AkaDet Not found " + id) );
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


