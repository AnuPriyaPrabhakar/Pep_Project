package com.ponsun.pep.master.CompanyMaster.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.master.CompanyMaster.request.CreateCompanyMasterRequest;
import com.ponsun.pep.master.CompanyMaster.request.UpdateCompanyMasterRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_config_company")
public class CompanyMaster extends BaseEntity {
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


    public static CompanyMaster create(final CreateCompanyMasterRequest createCompanyMasterRequest){
        final CompanyMaster companyMaster = new CompanyMaster();
        companyMaster.setName(createCompanyMasterRequest.getName());
        companyMaster.setUid(createCompanyMasterRequest.getUid());
        companyMaster.setStatus(Status.ACTIVE);
        companyMaster.setCreatedAt(LocalDateTime.now());
        return companyMaster;
    }
    public void update(final UpdateCompanyMasterRequest updateCompanyMasterRequest){
        this.setName(updateCompanyMasterRequest.getName());
        this.setEuid(updateCompanyMasterRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
