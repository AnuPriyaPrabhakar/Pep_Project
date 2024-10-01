package com.ponsun.pep.adminconfiguration.AdminUser.services;

import com.ponsun.pep.adminconfiguration.AdminUser.data.UserDataValidator;
import com.ponsun.pep.adminconfiguration.AdminUser.domain.User;
import com.ponsun.pep.adminconfiguration.AdminUser.domain.UserRepository;
import com.ponsun.pep.adminconfiguration.AdminUser.domain.UserRepositoryWrapper;
import com.ponsun.pep.adminconfiguration.AdminUser.request.CreateUserRequest;
import com.ponsun.pep.adminconfiguration.AdminUser.request.UpdateUserRequest;
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
public class UserWritePlatformServiceImpl implements UserWritePlatformService  {

    private final UserRepository userRepository;
    private final UserRepositoryWrapper userRepositoryWrapper;
    private final UserDataValidator userDataValidator;
    @Override
    @Transactional
    public Response createUser(CreateUserRequest createUserRequest) {
        try {
         this.userDataValidator.validateSaveModuleDet(createUserRequest);
            final User user = User.create(createUserRequest);
            this.userRepository.saveAndFlush(user);
            return Response.of(Long.valueOf(user.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }




    @Override
    @Transactional
    public Response updateUser(Integer id, UpdateUserRequest updateUserRequest) {
        try {
            this.userDataValidator.validateUpdateModuleDet(updateUserRequest);
           final User user = this.userRepositoryWrapper.findOneWithNotFoundDetection(id);
            user.update(updateUserRequest);
             this.userRepository.saveAndFlush(user);
            return Response.of(Long.valueOf(user.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockUser(Integer id) {
        try {
            final User user = this.userRepositoryWrapper.findOneWithNotFoundDetection(id);
            user.setStatus(Status.DELETE);
            user.setUpdatedAt(LocalDateTime.now());
            this.userRepository.saveAndFlush(user);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Response unblockUser(Integer id) {
        try {
            final User user = this.userRepositoryWrapper.findOneWithNotFoundDetection(id);
            user.setStatus(Status.ACTIVE);
            user.setUpdatedAt(LocalDateTime.now());
            this.userRepository.saveAndFlush(user);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

}
