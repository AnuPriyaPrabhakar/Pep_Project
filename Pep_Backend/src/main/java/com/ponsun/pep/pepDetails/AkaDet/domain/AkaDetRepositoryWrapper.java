package com.ponsun.pep.pepDetails.AkaDet.domain;

import com.ponsun.pep.pepDetails.AkaDet.request.AbstractAkaDetRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AkaDetRepositoryWrapper extends AbstractAkaDetRequest {
    private final AkaDetRepository akaDetRepository;

    @Transactional
    public AkaDet findOneWithNotFoundDetection(final Integer id){
        return this.akaDetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AkaDet Not found " + id) );

    }

    @Transactional
    public List<AkaDet> findOnePepIdWithNotFoundDetection(final Integer pepId){
        return this.akaDetRepository.findByPepId(pepId);
    }
    @Override
    public String toString(){
        return super.toString();
    }

}
