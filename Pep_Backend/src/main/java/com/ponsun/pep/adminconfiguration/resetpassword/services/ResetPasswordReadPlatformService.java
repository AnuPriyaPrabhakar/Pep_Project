package com.ponsun.pep.adminconfiguration.resetpassword.services;

import com.ponsun.pep.adminconfiguration.resetpassword.domain.ResetPassword;
import java.util.List;

public interface ResetPasswordReadPlatformService {
    ResetPassword fetchResetPasswordById(Integer id);
    List<ResetPassword> fetchAllResetPassword();


}
