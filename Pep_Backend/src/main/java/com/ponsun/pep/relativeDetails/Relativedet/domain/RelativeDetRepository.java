package com.ponsun.pep.relativeDetails.Relativedet.domain;

import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDetDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelativeDetRepository extends JpaRepository<RelativeDet,Integer> {

   // Optional<RelativeDet>findById(Integer id);
    List<RelativeDetDTO> findByRelativeId(@Param("relativeId") Integer relativeId);
    List<RelativeDet> findByPepId(Integer pepId);


    //List<RelativeDetDTO> findByRelativeId(Integer relativeId);
}
