package com.ponsun.pep.pepDetails.Customer.data;
import lombok.Data;

@Data
public class CustomerData {
    private Integer id;
    private String name;
    private String sourceLink;
    private Integer genderId;
    private String placeOfBirth;
    private String education;
    private String dob;
    private String pan;
    private String directorsIdentificationNumber;
    private Integer adverseInformation;
    private Integer regulatoryAction;
    private Integer uid;
    private Integer euid;
    private String qcViewDt;
    private String qcEditDt;
    private String managerApproveDt;
    private String qcPendingDt;
    private String publishedDt;
    private String managerPendingDt;

    public CustomerData(final Integer id, final String name,final String sourceLink,final Integer genderId, String education, final String placeOfBirth, String dob,final String pan,final String directorsIdentificationNumber,final Integer adverseInformation, final Integer regulatoryAction,final Integer uid,final Integer euid,final String qcViewDt,final String qcEditDt,final  String managerApproveDt,final String qcPendingDt,final String publishedDt,final String managerPendingDt) {
        this.id=id;
        this.name=name;
        this.sourceLink=sourceLink;
        this.genderId = genderId;
        this.education=education;
        this.placeOfBirth = placeOfBirth;
        this.dob=dob;
        this.pan=pan;
        this.directorsIdentificationNumber=directorsIdentificationNumber;
        this.adverseInformation = adverseInformation;
        this.regulatoryAction = regulatoryAction;
        this.uid = uid;
        this.euid = euid;
        this.qcViewDt = qcViewDt;
        this.qcEditDt = qcEditDt;
        this.managerApproveDt = managerApproveDt;
        this.qcPendingDt = qcPendingDt;
        this.publishedDt = publishedDt;
        this.managerPendingDt = managerPendingDt;

    }
    public static CustomerData newInstance(final Integer id, final String name,final String sourceLink,final Integer genderId,final String education,final String placeOfBirth,final String dob,final String pan,final String directorsIdentificationNumber, final Integer adverseInformation,final  Integer regulatoryAction,final Integer uid,final Integer euid,final String qcViewDt,final String qcEditDt,final  String managerApproveDt,final String qcPendingDt,final String publishedDt,final String managerPendingDt) {
        return new CustomerData(id, name, sourceLink,genderId,education,placeOfBirth , dob, pan, directorsIdentificationNumber,adverseInformation,regulatoryAction,uid,euid,qcViewDt,qcEditDt,managerApproveDt,qcPendingDt,publishedDt,managerPendingDt);
    }

}
