package com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.CreateCompaniesAddressRequest;
import com.ponsun.pep.companiesAndLlp.AssCompaniesAddress.request.UpdateCompaniesAddressRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_asscompanies_address_det")
public class CompaniesAddress extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "companyId")
    private Integer companyId;

    @Column(name = "registeredAddress")
    private String registeredAddress;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static CompaniesAddress create(final CreateCompaniesAddressRequest createCompaniesAddressRequest){
        final CompaniesAddress companiesAddress = new CompaniesAddress();
        companiesAddress.setCompanyId(createCompaniesAddressRequest.getCompanyId());
        companiesAddress.setRegisteredAddress(createCompaniesAddressRequest.getRegisteredAddress());
        companiesAddress.setUid(createCompaniesAddressRequest.getUid());
        companiesAddress.onCreate();
        companiesAddress.setStatus(Status.ACTIVE);
        return companiesAddress;
    }
    public void update(UpdateCompaniesAddressRequest updateCompaniesAddressRequest){
        this.setCompanyId(updateCompaniesAddressRequest.getCompanyId());
        this.setRegisteredAddress(updateCompaniesAddressRequest.getRegisteredAddress());
        this.setEuid(updateCompaniesAddressRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateCompaniesAddressRequest updateCompaniesAddressRequest){
        this.setEuid(updateCompaniesAddressRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
