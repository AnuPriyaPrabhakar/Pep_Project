package com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.CreateAssCompanyContactDetRequest;
import com.ponsun.pep.companiesAndLlp.AssociatedCompaniesContactDet.request.UpdateAssCompanyContactDetRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_asscompanies_contact_det")
public class AssCompanyContactDet extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "companyId")
    private Integer companyId;

    @Column(name = "emailID")
    private String emailID;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static AssCompanyContactDet create (final CreateAssCompanyContactDetRequest createAssCompanyContactDetRequest) {
        final AssCompanyContactDet assCompanyContactDet = new AssCompanyContactDet();
        assCompanyContactDet.setCompanyId(createAssCompanyContactDetRequest.getCompanyId());
        assCompanyContactDet.setEmailID(createAssCompanyContactDetRequest.getEmailID());
        assCompanyContactDet.setUid(createAssCompanyContactDetRequest.getUid());
        assCompanyContactDet.onCreate();
        assCompanyContactDet.setStatus(Status.ACTIVE);
        return assCompanyContactDet;
    }
    public void update(UpdateAssCompanyContactDetRequest updateAssCompanyContactDetRequest) {
        this.setCompanyId(updateAssCompanyContactDetRequest.getCompanyId());
        this.setEmailID(updateAssCompanyContactDetRequest.getEmailID());
        this.setEuid(updateAssCompanyContactDetRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(final UpdateAssCompanyContactDetRequest updateAssCompanyContactDetRequest){
        this.setEuid(updateAssCompanyContactDetRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }
}
