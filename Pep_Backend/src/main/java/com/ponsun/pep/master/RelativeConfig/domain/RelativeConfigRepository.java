package com.ponsun.pep.master.RelativeConfig.domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RelativeConfigRepository extends JpaRepository<RelativeConfig, Integer> {
    Optional<RelativeConfig> findById(Integer id);

}
