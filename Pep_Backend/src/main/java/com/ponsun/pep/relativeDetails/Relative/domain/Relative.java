package com.ponsun.pep.relativeDetails.Relative.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.relativeDetails.Relative.request.CreateRelativeRequest;
import com.ponsun.pep.relativeDetails.Relative.request.UpdateRelativeRequest;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_relative")
public class Relative extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "relativeMasterId")
    private Integer relativeMasterId;

    @Column(name = "relativeName")
    private String relativeName;

    @Column(name = "pan")
    private String pan;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static Relative create(final CreateRelativeRequest createRelativeRequest){
        final Relative relative = new Relative();
        relative.setPepId(createRelativeRequest.getPepId());
        relative.setRelativeMasterId(createRelativeRequest.getRelativeMasterId());
        relative.setRelativeName(createRelativeRequest.getRelativeName());
        relative.setPan(createRelativeRequest.getPan());
        relative.setUid(createRelativeRequest.getUid());
        relative.setCreatedAt(LocalDateTime.now());
        relative.setStatus(Status.ACTIVE);
        return relative;

    }
    public void update(final UpdateRelativeRequest updateRelativeRequest){
        this.setPepId(updateRelativeRequest.getPepId());
        this.setRelativeMasterId(updateRelativeRequest.getRelativeMasterId());
        this.setRelativeName(updateRelativeRequest.getRelativeName());
        this.setPan(updateRelativeRequest.getPan());
        this.setEuid(updateRelativeRequest.getEuid());
        this.setUpdatedAt(LocalDateTime.now());
        this.setStatus(Status.ACTIVE);
    }

    public static Relative createthrwDTO(final RelativeDTO createRelativeDTORequest){
        final Relative relative = new Relative();
        relative.setPepId(createRelativeDTORequest.getPepId());
        relative.setRelativeMasterId(createRelativeDTORequest.getRelativeMasterId());
        relative.setRelativeName(createRelativeDTORequest.getRelativeName());
        relative.setPan(createRelativeDTORequest.getPan());
        relative.setCreatedAt(LocalDateTime.now());
        relative.setStatus(Status.ACTIVE);
        return relative;

    }
//    public static Search createElasticSearchToJpa(final CriminalSearchDTO createSearchRequest) {
//        final Search search = new Search();
//        search.setName(createSearchRequest.getNAME());
//        search.setMatchingScore(createSearchRequest.getMatching_score());
//        search.setListId(createSearchRequest.getListId());
//        search.setTypeId(createSearchRequest.getTypeId());
//        search.setStateId(createSearchRequest.getStateId());
//        search.setCountryId(createSearchRequest.getCountryId());
//        search.setIdentity(createSearchRequest.getIdentity());
//        search.setLevelId(createSearchRequest.getLevelId());
//        //crmSearch.setDt(createCrmSearchRequest.getDt());
//        search.setUid(Long.valueOf(createSearchRequest.getUid()));
//        search.setValid(true);
//        search.setStatus(Status.ACTIVE);
//
//        return search;
//    }


    public void deactive(final UpdateRelativeRequest updateRelativeRequest){
      this.setEuid(updateRelativeRequest.getEuid());
      this.onUpdate();
      this.setStatus(Status.DELETE);

    }
}
