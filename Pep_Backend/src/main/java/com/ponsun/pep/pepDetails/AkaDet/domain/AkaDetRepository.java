package com.ponsun.pep.pepDetails.AkaDet.domain;

import com.ponsun.pep.pepDetails.AkaDet.data.AkaDetData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AkaDetRepository extends JpaRepository<AkaDet,Integer> {

    Optional<AkaDet> findById(Integer id);

    List<AkaDet> findByPepId(Integer pepId);
}
