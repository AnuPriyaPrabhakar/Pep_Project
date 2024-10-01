package com.ponsun.pep.relativeDetails.Relative.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.relativeDetails.Relative.data.RelativeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RelativeRepository extends JpaRepository<Relative,Integer> {
    Optional<Relative> findById(Integer id);
    //@Query(nativeQuery = true)
    //@Query("SELECT r FROM Relative r WHERE r.pepId = :pepId")
    List<RelativeData> findByPepId(@Param("pepId") Integer pepId);
    List<Relative> findByPepIdAndRelativeMasterId(@Param("pepId") Integer pepId,@Param("relativeMasterId") Integer relativeMasterId);


    List<RelativeData> findByPepIdAndStatus(@Param("pepId") Integer pepId, Status string);


}
