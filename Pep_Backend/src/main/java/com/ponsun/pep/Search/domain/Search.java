package com.ponsun.pep.Search.domain;

import com.ponsun.pep.Search.request.CreateSearchRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name="pep_search")
public class Search extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="searchingScore")
    private String searchingScore;

    @Column(name="uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    @Column(name = "applicantFormId")
    private Integer applicantFormId;

    public static Search create(final CreateSearchRequest createSearchRequest){
        final Search search = new Search();
        search.setId(createSearchRequest.getId());
        search.setName(createSearchRequest.getName());
        search.setSearchingScore(createSearchRequest.getSearchingScore());
        search.setUid(createSearchRequest.getUid());
        search.setEuid(createSearchRequest.getEuid());
        search.setApplicantFormId(createSearchRequest.getApplicantFormId());
        search.setStatus(Status.ACTIVE);
        search.onCreate();
        return search;
    }
}
