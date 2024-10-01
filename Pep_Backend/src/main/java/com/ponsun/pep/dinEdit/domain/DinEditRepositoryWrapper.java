package com.ponsun.pep.dinEdit.domain;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DinEditRepositoryWrapper {
    private final DinEditRepository dinEditRepository;

    @Transactional
    public DinEdit findOneWithNotFoundDetection(final Integer id){
        return this.dinEditRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("DinEdit Not found "+id));
    }
    @Override
    public String toString() {return super.toString();}
}
