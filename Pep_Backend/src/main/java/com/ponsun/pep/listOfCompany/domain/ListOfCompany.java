package com.ponsun.pep.listOfCompany.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.listOfCompany.request.CreateListOfCompanyRequest;
import com.ponsun.pep.listOfCompany.request.UpdateListOfCompanyRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name="pep_list_of_company")
public class ListOfCompany extends BaseEntity {
    private static final long serialVersioUID = 1L;

    @Id
    @Column(name ="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="type")
    private String type;

    @Column(name="uid")
    private Integer uid;

    @Column(name="euid")
    private Integer euid;

    public static  ListOfCompany create(final CreateListOfCompanyRequest createListOfCompanyRequest){
        final ListOfCompany listOfCompany = new ListOfCompany();
        listOfCompany.setType(createListOfCompanyRequest.getType());
        listOfCompany.setUid(createListOfCompanyRequest.getUid());
        listOfCompany.setStatus(Status.ACTIVE);
        listOfCompany.setCreatedAt(LocalDateTime.now());
        return listOfCompany;
    }
    public void update(final UpdateListOfCompanyRequest updateListOfCompanyRequest){
        this.setType(updateListOfCompanyRequest.getType());
        this.setEuid(updateListOfCompanyRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
