package com.ponsun.pep.roles.RoleDetails.domain;

import com.ponsun.pep.roles.RoleDetails.request.AbstractRoleDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoleDetailsRepositoryWrapper extends AbstractRoleDetailsRequest {
    private final RoleDetailsRepository roleDetailsRepository;

    @Transactional
    public RoleDetails findOneWithNotFoundDetection(final Integer id){
        return this.roleDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("RoleDetails Not found " + id) );

    }

//    @Transactional
//    public List<RoleDetails> findOnePepIdWithNotFoundDetection(final Integer pepId){
//        return this.roleDetailsRepository.findByPepId(pepId);
//    }
    @Override
    public String toString(){
        return super.toString();
    }
}
