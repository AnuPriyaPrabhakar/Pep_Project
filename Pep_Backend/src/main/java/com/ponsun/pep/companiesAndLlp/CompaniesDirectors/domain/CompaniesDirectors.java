package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.domain;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.CreatCompaniesDirectorsRequest;
import com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request.UpdateCompaniesDirectorsRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
//@Accessors(chain = true)
@Table(name = "pep_companies_directors")
public class CompaniesDirectors extends BaseEntity {
    private static final long serialVersionUID = 1L;
    //  id  director_id   pepId  companyId  status  updated_at     uid    euid
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "companyId")
    private Integer companyId;

    @Column(name = "directorId")
    private Integer directorId;

    @Column(name = "designationId")
    private Integer designationId;

    @Column(name = "companyMasterId")
    private Integer companyMasterId;

    @Column(name = "appointmentDate")
    private String appointmentDate;

    @Column(name = "cessationDate")
    private String cessationDate;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static CompaniesDirectors create(final CreatCompaniesDirectorsRequest createCompaniesDirectorsRequest){
        final CompaniesDirectors companiesDirectors = new CompaniesDirectors();
        companiesDirectors.setDirectorId(createCompaniesDirectorsRequest.getDirectorId());
        companiesDirectors.setDesignationId(createCompaniesDirectorsRequest.getDesignationId());
        companiesDirectors.setCompanyMasterId(createCompaniesDirectorsRequest.getCompanyMasterId());
        companiesDirectors.setAppointmentDate(createCompaniesDirectorsRequest.getAppointmentDate());
        companiesDirectors.setCessationDate(createCompaniesDirectorsRequest.getCessationDate());
        companiesDirectors.setCompanyId(createCompaniesDirectorsRequest.getCompanyId());
        companiesDirectors.setUid(createCompaniesDirectorsRequest.getUid());
        companiesDirectors.onCreate();
        companiesDirectors.setStatus(Status.ACTIVE);
        return companiesDirectors;
    }
    public void update(UpdateCompaniesDirectorsRequest updateCompaniesDirectorsRequest){
        this.setDirectorId(updateCompaniesDirectorsRequest.getDirectorId());
        this.setCompanyMasterId(updateCompaniesDirectorsRequest.getCompanyMasterId());
        this.setDesignationId(updateCompaniesDirectorsRequest.getDesignationId());
        this.setAppointmentDate(updateCompaniesDirectorsRequest.getAppointmentDate());
        this.setCessationDate(updateCompaniesDirectorsRequest.getCessationDate());
        this.setCompanyId(updateCompaniesDirectorsRequest.getCompanyId());
        this.setEuid(updateCompaniesDirectorsRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
    public void deactive(UpdateCompaniesDirectorsRequest updateCompaniesDirectorsRequest){
        this.setEuid(updateCompaniesDirectorsRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
