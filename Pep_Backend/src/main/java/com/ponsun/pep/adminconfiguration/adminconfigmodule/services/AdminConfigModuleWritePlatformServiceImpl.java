package com.ponsun.pep.adminconfiguration.adminconfigmodule.services;


import com.ponsun.pep.adminconfiguration.adminconfigmodule.data.AdminConfigModuleDataValidator;
import com.ponsun.pep.adminconfiguration.adminconfigmodule.domain.AdminConfigModule;
import com.ponsun.pep.adminconfiguration.adminconfigmodule.domain.AdminConfigModuleRepository;
import com.ponsun.pep.adminconfiguration.adminconfigmodule.domain.AdminConfigModuleRepositoryWrapper;
import com.ponsun.pep.adminconfiguration.adminconfigmodule.request.CreateAdminConfigModuleRequest;
import com.ponsun.pep.adminconfiguration.adminconfigmodule.request.UpdateAdminConfigModuleRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.domain.AssociatedCompanies;
import com.ponsun.pep.companiesAndLlp.AssociatedCompanies.request.UpdateAssociatedCompaniesRequest;
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

public class AdminConfigModuleWritePlatformServiceImpl implements AdminConfigModuleWritePlatformService {
    private final AdminConfigModuleRepository adminConfigModuleRepository;
    private final AdminConfigModuleRepositoryWrapper adminConfigModuleRepositoryWrapper;
    private final AdminConfigModuleDataValidator adminConfigModuleDataValidator;

    @Transactional
    public Response createAdminConfigModule(CreateAdminConfigModuleRequest createAdminConfigModuleRequest) {
        try {
            this.adminConfigModuleDataValidator.validateSaveAdminConfigModule(createAdminConfigModuleRequest);
            final AdminConfigModule adminConfigModule = AdminConfigModule.create(createAdminConfigModuleRequest);
            this.adminConfigModuleRepository.saveAndFlush(adminConfigModule);
              return Response.of(Long.valueOf(adminConfigModule.getId()));

        } catch (DataIntegrityViolationException e) {
            log.error("Error creating AdminConfigModule: {}", e.getMessage(), e);
            throw new EQAS_PEP_AppicationException("Error creating AdminConfigModule: " + e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateAdminConfigModule(Integer id, UpdateAdminConfigModuleRequest updateAdminConfigModuleRequest) {
        try {
            this.adminConfigModuleDataValidator.validateUpdateAdminConfigModule(updateAdminConfigModuleRequest);
            final AdminConfigModule adminConfigModule = this.adminConfigModuleRepositoryWrapper.findOneWithNotFoundDetection(id);
            adminConfigModule.update(updateAdminConfigModuleRequest);
            this.adminConfigModuleRepository.saveAndFlush(adminConfigModule);
              return Response.of(Long.valueOf(adminConfigModule.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response deactive(Integer pepId, Integer euid){
        try{
            AdminConfigModule adminConfigModule = this.adminConfigModuleRepositoryWrapper.findOneWithNotFoundDetection(pepId);
            adminConfigModule.setEuid(euid);
            adminConfigModule.setStatus(Status.ACTIVE);
            adminConfigModule.setUpdatedAt(LocalDateTime.now());

            return Response.of(Long.valueOf(adminConfigModule.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockAdminConfigModule(Integer id) {
        try {
            final AdminConfigModule adminConfigModule = this.adminConfigModuleRepositoryWrapper.findOneWithNotFoundDetection(id);
            adminConfigModule.setValid(false);
            adminConfigModule.setStatus(Status.DELETE);
            adminConfigModule.setUpdatedAt(LocalDateTime.now());
            this.adminConfigModuleRepository.saveAndFlush(adminConfigModule);
             return Response.of(Long.valueOf(id));

        }catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockAdminConfigModule(Integer id){
       try {
           final AdminConfigModule adminConfigModule = this.adminConfigModuleRepositoryWrapper.findOneWithNotFoundDetection(id);
           adminConfigModule.setValid(true);
           adminConfigModule.setStatus(Status.ACTIVE);
           adminConfigModule.setUpdatedAt(LocalDateTime.now());
           this.adminConfigModuleRepository.saveAndFlush(adminConfigModule);
            return Response.of(Long.valueOf(id));

       } catch (DataIntegrityViolationException e){
           throw new EQAS_PEP_AppicationException(e.getMessage());
       }
    }
}
