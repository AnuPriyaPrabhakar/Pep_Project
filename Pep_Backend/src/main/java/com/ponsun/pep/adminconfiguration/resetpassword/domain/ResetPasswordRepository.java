package com.ponsun.pep.adminconfiguration.resetpassword.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ResetPasswordRepository extends JpaRepository<ResetPassword, Integer> {
    Optional<ResetPassword> findById(Integer id);


}