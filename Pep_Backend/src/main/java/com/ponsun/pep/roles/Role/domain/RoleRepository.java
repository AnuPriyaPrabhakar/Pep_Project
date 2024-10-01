package com.ponsun.pep.roles.Role.domain;

import com.ponsun.pep.roles.RoleDetails.domain.RoleDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findById(Integer id);
}