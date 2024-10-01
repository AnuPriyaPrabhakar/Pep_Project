package com.ponsun.pep.pepDetails.Customer.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.pepDetails.Customer.request.CreateCustomerRequest;
import com.ponsun.pep.pepDetails.Customer.request.UpdateCustomerRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
//@Accessors(chain = true)
@Table(name = "pep_customer")
public class Customer extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "sourceLink",columnDefinition = "TEXT")
    private String sourceLink;

    @Column(name = "genderId")
    private Integer genderId;

    @Lob
    @Column(name = "education",columnDefinition = "TEXT")
    private String education;

    @Column(name = "placeOfBirth")
    private String placeOfBirth;

    @Column(name = "dob")
    private String dob;

    @Column(name = "pan")
    private String pan;

    @Column(name = "directorsIdentificationNumber")
    private String directorsIdentificationNumber;

    @Column(name = "adverseInformation")
    private Integer adverseInformation;

    @Column(name = "regulatoryAction")
    private Integer regulatoryAction;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    @Column(name = "qc_view_dt")
    private String qcViewDt;

    @Column(name = "qc_edit_dt")
    private String qcEditDt;

    @Column(name = "manager_approve_dt")
    private String managerApproveDt;

    @Column(name = "qc_pending_dt")
    private String qcPendingDt;

    @Column(name = "published_dt")
    private String publishedDt;

    @Column(name = "manager_pending_dt")
    private String managerPendingDt;

    public static Customer create(final CreateCustomerRequest createCustomerRequest) {
        final Customer customer = new Customer();
        customer.setName(createCustomerRequest.getName());
        customer.setSourceLink(createCustomerRequest.getSourceLink());
        customer.setEducation(createCustomerRequest.getEducation());
        customer.setGenderId(createCustomerRequest.getGenderId());
        customer.setPlaceOfBirth(createCustomerRequest.getPlaceOfBirth());
        customer.setDob(createCustomerRequest.getDob());
        customer.setPan(createCustomerRequest.getPan());
        customer.setDirectorsIdentificationNumber(createCustomerRequest.getDirectorsIdentificationNumber());
        customer.setAdverseInformation(createCustomerRequest.getAdverseInformation());
        customer.setRegulatoryAction(createCustomerRequest.getRegulatoryAction());
        customer.setUid(createCustomerRequest.getUid());
        customer.onCreate();
        customer.setStatus(Status.ACTIVE);
        return customer;
    }
    public void update(final UpdateCustomerRequest updateCustomerRequest){
        this.setName(updateCustomerRequest.getName());
        this.setSourceLink(updateCustomerRequest.getSourceLink());
        this.setEducation(updateCustomerRequest.getEducation());
        this.setGenderId(updateCustomerRequest.getGenderId());
        this.setPlaceOfBirth(updateCustomerRequest.getPlaceOfBirth());
        this.setDob(updateCustomerRequest.getDob());
        this.setPan(updateCustomerRequest.getPan());
        this.setDirectorsIdentificationNumber(updateCustomerRequest.getDirectorsIdentificationNumber());
        this.setAdverseInformation(updateCustomerRequest.getAdverseInformation());
        this.setRegulatoryAction(updateCustomerRequest.getRegulatoryAction());
        this.setEuid(updateCustomerRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.onUpdate();
    }
    public void deactive(final UpdateCustomerRequest updateCustomerRequest){
        this.setEuid(updateCustomerRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }

    public void qcupdate(final UpdateCustomerRequest updateCustomerRequest){
        this.setQcViewDt(updateCustomerRequest.getQcViewDt());
        this.setQcEditDt(updateCustomerRequest.getQcEditDt());
        this.setManagerApproveDt(updateCustomerRequest.getManagerApproveDt());
        this.setQcPendingDt(updateCustomerRequest.getQcPendingDt());
        this.setPublishedDt(updateCustomerRequest.getPublishedDt());
        this.setManagerPendingDt(updateCustomerRequest.getManagerPendingDt());
        this.onUpdate();
    }

    public void checked(String checked) {
        if (checked.equals("AdverseInformation")) {
            this.setAdverseInformation(1);
            this.onUpdate();
        }
        if (status.equals("RegulatoryAction")) {
            this.setRegulatoryAction(1);
            this.onUpdate();
        }
    }
}
