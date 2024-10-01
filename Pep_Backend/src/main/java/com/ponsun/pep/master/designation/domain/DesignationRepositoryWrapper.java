package com.ponsun.pep.master.designation.domain;


import com.ponsun.pep.master.designation.request.AbstractDesignationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DesignationRepositoryWrapper extends AbstractDesignationRequest {
    private final DesignationRepository designationRepository;

    @Transactional
    public Designation findOneWithNotFoundDetection(final Integer id){
        return (Designation) this.designationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Designation Not found " + id));

    }
    @Override
    public String toString(){return super.toString();

    }

}
