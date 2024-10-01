//package com.ponsun.pep.searchDetails.domain;
//
//import com.ponsun.pep.common.entity.Status;
//import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
//import com.ponsun.pep.searchDetails.request.CreateSearchDetailsRequest;
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.experimental.Accessors;
//
//import java.time.LocalDateTime;
//
//@Data
//@Entity
//@Accessors(chain = true)
//@Table(name="pep_search_details")
//public class SearchDetails extends BaseEntity {
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @Column(name="id",nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name="searchId")
//    private Integer searchId;
//
//    @Column(name="name")
//    private String name;
//
//    @Column(name="matchingScore")
//    private Double matchingScore;
//
//    @Column(name="uid")
//    private Integer uid;
//
//    @Column(name = "euid")
//    private Integer euid;
//
//    @Column(name = "kycId")
//    private Integer kycId;
//    public static SearchDetails create(final CreateSearchDetailsRequest createSearchDetailsRequest){
//        final SearchDetails searchDetails = new SearchDetails();
//        searchDetails.setSearchId(createSearchDetailsRequest.getSearchId());
//        searchDetails.setName(createSearchDetailsRequest.getName());
//        searchDetails.setMatchingScore(createSearchDetailsRequest.getMatchingScore());
//        searchDetails.setUid(createSearchDetailsRequest.getUid());
//        searchDetails.setEuid(createSearchDetailsRequest.getEuid());
//        searchDetails.setStatus(Status.ACTIVE);
//        searchDetails.setCreatedAt(LocalDateTime.now());
//        return searchDetails;
//    }
//}


package com.ponsun.pep.searchDetails.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.searchDetails.request.CreateSearchDetailsRequest;
import com.ponsun.pep.searchDetails.request.UpdateSearchDetailsRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name="pep_search_details")
public class SearchDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="euid")
    private Integer euid;

    @Column(name="searchId")
    private Integer searchId;

    @Column(name="countryId")
    private Integer countryId;

    @Column(name="identity")
    private String identity;

    @Column(name="levelId")
    private Long levelId;

    @Column(name="listId")
    private Integer listId;

    @Column(name="matchingscore")
    private Double matchingScore;

    @Column(name="name")
    private String name;

    @Column(name="type_id")
    private Integer typeId;

    @Column(name="state_id")
    private Integer stateId;

    @Column(name="uid")
    private Integer uid;

    @Column(name="valid")
    private Boolean valid;

    @Column(name="kycId")
    private Integer kycId;

    @Column(name="applicantId")
    private Integer applicantId;

    public static  SearchDetails create(final CreateSearchDetailsRequest createSearchDetailsRequest){
        final SearchDetails searchDetails = new SearchDetails();
        searchDetails.setId(createSearchDetailsRequest.getId());
        searchDetails.setEuid(createSearchDetailsRequest.getEuid());
        searchDetails.setSearchId(createSearchDetailsRequest.getSearchId());
        searchDetails.setCountryId(createSearchDetailsRequest.getCountryId());
        searchDetails.setIdentity(createSearchDetailsRequest.getIdentity());
        searchDetails.setLevelId(createSearchDetailsRequest.getLevelId());
        searchDetails.setListId(createSearchDetailsRequest.getListId());
        searchDetails.setMatchingScore(createSearchDetailsRequest.getMatchingScore());
        searchDetails.setName(createSearchDetailsRequest.getName());
        searchDetails.setTypeId(createSearchDetailsRequest.getTypeId());
        searchDetails.setStateId(createSearchDetailsRequest.getStateId());
        searchDetails.setUid(createSearchDetailsRequest.getUid());
        searchDetails.setValid(createSearchDetailsRequest.getValid());
        searchDetails.setKycId(createSearchDetailsRequest.getKycId());
        searchDetails.setApplicantId(createSearchDetailsRequest.getApplicantId());
        searchDetails.setStatus(Status.ACTIVE);
        searchDetails.onCreate();
        return searchDetails;
    }
    public void update(final UpdateSearchDetailsRequest updateSearchDetailsRequest){
        this.setId(updateSearchDetailsRequest.getId());
        this.setEuid(updateSearchDetailsRequest.getEuid());
        this.setSearchId(updateSearchDetailsRequest.getSearchId());
        this.setCountryId(updateSearchDetailsRequest.getCountryId());
        this.setIdentity(updateSearchDetailsRequest.getIdentity());
        this.setLevelId(updateSearchDetailsRequest.getLevelId());
        this.setListId(updateSearchDetailsRequest.getListId());
        this.setMatchingScore(updateSearchDetailsRequest.getMatchingScore());
        this.setName(updateSearchDetailsRequest.getName());
        this.setTypeId(updateSearchDetailsRequest.getTypeId());
        this.setStateId(updateSearchDetailsRequest.getStateId());
        this.setUid(updateSearchDetailsRequest.getUid());
        this.setValid(updateSearchDetailsRequest.getValid());
        this.setKycId(updateSearchDetailsRequest.getKycId());
        this.setStatus(Status.ACTIVE);
        this.onUpdate();
    }
}
