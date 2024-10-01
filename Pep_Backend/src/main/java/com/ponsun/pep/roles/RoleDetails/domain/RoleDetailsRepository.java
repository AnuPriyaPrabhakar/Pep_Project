package com.ponsun.pep.roles.RoleDetails.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDetailsRepository extends JpaRepository<RoleDetails,Integer> {
    Optional<RoleDetails> findById(Integer id);

//    List<RoleDetails> findByPepId(Integer pepId);
}
