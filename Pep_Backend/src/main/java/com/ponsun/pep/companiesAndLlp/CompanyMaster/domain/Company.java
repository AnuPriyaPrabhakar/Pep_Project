package com.ponsun.pep.companiesAndLlp.CompanyMaster.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.request.CreateCompanyRequest;
import com.ponsun.pep.companiesAndLlp.CompanyMaster.request.UpdateCompanyRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_company")
public class Company extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static Company create(final CreateCompanyRequest createCompanyRequest){
        final Company company = new Company();
        company.setName(createCompanyRequest.getName());
        company.setUid(createCompanyRequest.getUid());
        company.setStatus(Status.ACTIVE);
        company.setCreatedAt(LocalDateTime.now());
        return company;
    }
    public void update(final UpdateCompanyRequest updateCompanyRequest){
        this.setName(updateCompanyRequest.getName());
        this.setEuid(updateCompanyRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
