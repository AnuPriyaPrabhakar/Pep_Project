package com.ponsun.pep.roles.RoleDetails.services;

import com.ponsun.pep.roles.RoleDetails.data.RoleDetailsDataValidator;
import com.ponsun.pep.roles.RoleDetails.domain.RoleDetails;
import com.ponsun.pep.roles.RoleDetails.domain.RoleDetailsRepository;
import com.ponsun.pep.roles.RoleDetails.domain.RoleDetailsRepositoryWrapper;
import com.ponsun.pep.roles.RoleDetails.request.CreateRoleDetailsRequest;
import com.ponsun.pep.roles.RoleDetails.request.UpdateRoleDetailsRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleDetailsWritePlatformServiceImpl implements RoleDetailsWritePlatformService {
    private final RoleDetailsRepository roleDetailsRepository;
    private final RoleDetailsRepositoryWrapper roleDetailsRepositoryWrapper;
    private final RoleDetailsDataValidator roleDetailsDataValidator;

    @Override
    @Transactional
    public Response createRoleDetails(CreateRoleDetailsRequest createRoleDetailsRequest) {
        try {
            this.roleDetailsDataValidator.validateSaveRoleDetails(createRoleDetailsRequest);
            final RoleDetails roleDetails = RoleDetails.create(createRoleDetailsRequest);//entity
            this.roleDetailsRepository.saveAndFlush(roleDetails);
            return Response.of(Long.valueOf(roleDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateRoleDetails(Integer id, UpdateRoleDetailsRequest updateRoleDetailsRequest) {
        try {
            this.roleDetailsDataValidator.validateUpdateRoleDetails(updateRoleDetailsRequest);
            final RoleDetails roleDetails = this.roleDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            roleDetails.update(updateRoleDetailsRequest);
            this.roleDetailsRepository.saveAndFlush(roleDetails);
            return Response.of(Long.valueOf(roleDetails.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
//    @Override
//    @Transactional
//    public Response deactive(Integer pepId, Integer euid){
//        try{
//            List<RoleDetails> roleDetails = this.roleDetailsRepositoryWrapper.findOnePepIdWithNotFoundDetection(pepId);
//            Response response = null;
//            for (RoleDetails roleDetailses : roleDetails) {
//                roleDetailses.setEuid(euid);
//                roleDetailses.setStatus(Status.DELETE);
//                roleDetailses.setUpdatedAt(LocalDateTime.now());
//                response = Response.of(roleDetailses.getId());
//            }
//            return response;
//        }catch (DataIntegrityViolationException e){
//            throw new EQAS_PEP_AppicationException(e.getMessage());
//        }
//    }
    @Override
    @Transactional
    public Response blockRoleDetails(Integer id){
        try {
            final RoleDetails roleDetails = this.roleDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            roleDetails.setStatus(Status.DELETE); // Or set the appropriate status
            roleDetails.setUpdatedAt(LocalDateTime.now());
            this.roleDetailsRepository.saveAndFlush(roleDetails);
            return Response.of(Long.valueOf(id));

        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockRoleDetails(Integer id){
        try {
            final RoleDetails roleDetails = this.roleDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            roleDetails.setStatus(Status.ACTIVE); // Or set the appropriate status
            roleDetails.setUpdatedAt(LocalDateTime.now());
            this.roleDetailsRepository.saveAndFlush(roleDetails);
            return Response.of(Long.valueOf(id));


        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
