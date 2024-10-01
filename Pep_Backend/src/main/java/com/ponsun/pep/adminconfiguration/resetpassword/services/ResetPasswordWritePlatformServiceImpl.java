package com.ponsun.pep.adminconfiguration.resetpassword.services;

import com.ponsun.pep.adminconfiguration.resetpassword.data.ResetPasswordDataValidator;
import com.ponsun.pep.adminconfiguration.resetpassword.domain.ResetPassword;
import com.ponsun.pep.adminconfiguration.resetpassword.domain.ResetPasswordRepository;
import com.ponsun.pep.adminconfiguration.resetpassword.domain.ResetPasswordRepositoryWrapper;
import com.ponsun.pep.adminconfiguration.resetpassword.request.CreateResetPasswordRequest;
import com.ponsun.pep.adminconfiguration.resetpassword.request.UpdateResetPasswordRequest;
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
public class ResetPasswordWritePlatformServiceImpl implements ResetPasswordWritePlatformService {

    private final ResetPasswordRepository resetpasswordRepository;
    private  final ResetPasswordRepositoryWrapper resetpasswordRepositoryWrapper;
    private  final ResetPasswordDataValidator resetPasswordDataValidator;

    @Override
    @Transactional
    public Response createResetPassword(CreateResetPasswordRequest createResetPasswordRequest) {

        try {
            this.resetPasswordDataValidator.validateSaveResetPassword(createResetPasswordRequest);
            final ResetPassword resetPassword = ResetPassword.create(createResetPasswordRequest);//entity
            this.resetpasswordRepository.saveAndFlush(resetPassword);
            return Response.of(Long.valueOf(resetPassword.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateResetPassword(Integer id, UpdateResetPasswordRequest updateResetPasswordRequest) {
        try {
            this.resetPasswordDataValidator.validateUpdateResetPassword(updateResetPasswordRequest);
            final ResetPassword resetPassword = this.resetpasswordRepositoryWrapper.findOneWithNotFoundDetection(id);
            resetPassword.update(updateResetPasswordRequest);
            this.resetpasswordRepository.saveAndFlush(resetPassword);
            return Response.of(Long.valueOf(resetPassword.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockResetPassword(Integer id) {
        try {
            final ResetPassword resetPassword = this.resetpasswordRepositoryWrapper.findOneWithNotFoundDetection(id);
            resetPassword.setValid(false); // Set 'valid' to 0
            resetPassword.setStatus(Status.DELETE); // Or set the appropriate status
            resetPassword.setUpdatedAt(LocalDateTime.now());
            this.resetpasswordRepository.saveAndFlush(resetPassword);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockResetPassword(Integer id) {
        try {
            final ResetPassword resetPassword = this.resetpasswordRepositoryWrapper.findOneWithNotFoundDetection(id);
            resetPassword.setValid(true); // Set 'valid' to 1
            resetPassword.setStatus(Status.ACTIVE); // Or set the appropriate status
            resetPassword.setUpdatedAt(LocalDateTime.now());
            this.resetpasswordRepository.saveAndFlush(resetPassword);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
