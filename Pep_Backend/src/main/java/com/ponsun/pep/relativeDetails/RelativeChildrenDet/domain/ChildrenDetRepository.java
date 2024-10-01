package com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeChildrenDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChildrenDetRepository extends JpaRepository<ChildrenDet, Integer> {
    Optional<ChildrenDet> findById(Integer id);

    List<RelativeChildrenDTO> findByRelativeId(@Param("relativeId") Integer relativeId);

    List<ChildrenDet> findByPepId(Integer pepId);
}