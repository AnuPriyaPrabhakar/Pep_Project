package com.ponsun.pep.adminconfiguration.resetpassword.data;
import com.ponsun.pep.adminconfiguration.resetpassword.request.CreateResetPasswordRequest;
import com.ponsun.pep.adminconfiguration.resetpassword.request.UpdateResetPasswordRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ResetPasswordDataValidator {
    public void validateSaveResetPassword(final CreateResetPasswordRequest request) {
        if (request.getPassword() == null || request.getPassword().equals("")) {
            throw new EQAS_PEP_AppicationException("Password parameter required");
        }
    }
    public void validateUpdateResetPassword(final UpdateResetPasswordRequest request) {
        if (request.getPassword() == null || request.getPassword().equals("")) {
            throw new EQAS_PEP_AppicationException("ModuleName parameter required");
        }
    }
}
