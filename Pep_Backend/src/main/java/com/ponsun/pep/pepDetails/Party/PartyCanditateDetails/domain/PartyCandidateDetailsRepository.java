package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyCandidateDetailsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PartyCandidateDetailsRepository extends JpaRepository<PartyCandidateDetails, Integer> {
    Optional<PartyCandidateDetails> findById(Integer id);
    List<PartyCandidateDetailsData> findByPepIdAndStatus(@Param("pepId") Integer pepId, Status string);
    //List<PartyCandidateDetailsData> findByPepId(@Param("pepId") Integer pepId );

}
