package com.ponsun.pep.adminconfiguration.resetpassword.services;

import com.ponsun.pep.adminconfiguration.resetpassword.request.UpdateResetPasswordRequest;
import com.ponsun.pep.adminconfiguration.resetpassword.request.CreateResetPasswordRequest;
import com.ponsun.pep.infrastructure.utils.Response;

public interface ResetPasswordWritePlatformService {
     Response createResetPassword(CreateResetPasswordRequest createResetPasswordRequest);
     Response updateResetPassword(Integer id, UpdateResetPasswordRequest updateResetPasswordRequest);
    Response blockResetPassword(Integer id);
    Response unblockResetPassword(Integer id);
}
