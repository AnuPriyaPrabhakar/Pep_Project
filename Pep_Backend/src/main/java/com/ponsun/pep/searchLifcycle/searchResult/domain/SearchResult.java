package com.ponsun.pep.searchLifcycle.searchResult.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.searchLifcycle.searchResult.request.CreateSearchResultRequest;
import com.ponsun.pep.searchLifcycle.searchResult.request.UpdateSearchResultRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name="pep_search")
public class SearchResult extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "matching_score")
    private Double matching_score;

    @Column(name = "searchingScore")
    private Double searchingScore;

    @Column(name = "list_id")
    private Integer listId;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "identity")
    private String identity;

    @Column(name = "level_id")
    private Long levelId;

    @Column(name = "uid")
    private Long uid;

    @Column(name = "valid")
    private Boolean valid;

    @Column(name = "kycId")
    private Integer kycId;

    @Column(name = "applicantFormId")
    private Integer applicantFormId;

    @Column(name = "screeningType")
    private Integer screeningType;

    @Column(name = "isScreening")
    private Integer isScreening;


    public static SearchResult create(final CreateSearchResultRequest createSearchRequest) {
        final SearchResult searchResult = new SearchResult();
        searchResult.setName(createSearchRequest.getName());
        searchResult.setMatching_score(createSearchRequest.getMatching_score());
        searchResult.setSearchingScore(createSearchRequest.getSearchingScore());
        searchResult.setListId(createSearchRequest.getListId());
        searchResult.setTypeId(createSearchRequest.getTypeId());
        searchResult.setStateId(createSearchRequest.getStateId());
        searchResult.setCountryId(createSearchRequest.getCountryId());
        searchResult.setIdentity(createSearchRequest.getIdentity());
        searchResult.setLevelId(createSearchRequest.getLevelId());
        searchResult.setUid(createSearchRequest.getUid());
        searchResult.setValid(createSearchRequest.getValid());
        searchResult.setKycId(createSearchRequest.getKycId());
        searchResult.setScreeningType(createSearchRequest.getScreeningType());
        searchResult.setApplicantFormId(createSearchRequest.getApplicantFormId());
        searchResult.setIsScreening(createSearchRequest.getIsScreening());
        searchResult.setStatus(Status.ACTIVE);
        searchResult.onCreate();
        return searchResult;
    }

    public void update(final UpdateSearchResultRequest updateSearchRequest){
        this.setName(updateSearchRequest.getName());
        this.setMatching_score(updateSearchRequest.getMatching_score());
        this.setListId(updateSearchRequest.getListId());
        this.setTypeId(updateSearchRequest.getTypeId());
        this.setStateId(updateSearchRequest.getStateId());
        this.setCountryId(updateSearchRequest.getCountryId());
        this.setIdentity(updateSearchRequest.getIdentity());
        this.setLevelId(updateSearchRequest.getLevelId());
        this.setUid(updateSearchRequest.getUid());
        this.setValid(updateSearchRequest.getValid());
        this.setKycId(updateSearchRequest.getKycId());
        this.setScreeningType(updateSearchRequest.getScreeningType());
        this.setApplicantFormId(updateSearchRequest.getApplicantFormId());
        this.setIsScreening(updateSearchRequest.getIsScreening());
        this.setStatus(Status.ACTIVE);
        this.onUpdate();
    }
}
