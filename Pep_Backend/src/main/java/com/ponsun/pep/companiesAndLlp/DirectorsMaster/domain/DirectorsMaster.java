package com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain;


import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.CreateDirectorMasterRequest;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.request.UpdateDirectorMasterRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
//@Accessors(chain = true)
@Table(name ="pep_config_companies_directors")
public class DirectorsMaster extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "din")
    private String din;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static DirectorsMaster create (CreateDirectorMasterRequest createDirectorMasterRequest) {
        final DirectorsMaster directorsMaster = new DirectorsMaster();
        directorsMaster.setName(createDirectorMasterRequest.getName());
        directorsMaster.setDin(createDirectorMasterRequest.getDin());
        directorsMaster.setUid(createDirectorMasterRequest.getUid());
        directorsMaster.setStatus(Status.ACTIVE);
        directorsMaster.setCreatedAt(LocalDateTime.now());
        return directorsMaster;
    }

    public void update (final UpdateDirectorMasterRequest updateDirectorMasterRequest){
        this.setName(updateDirectorMasterRequest.getName());
        //this.setDin(updateDirectorMasterRequest.getDin());
        this.setUid(updateDirectorMasterRequest.getUid());
        this.setStatus(Status.ACTIVE);
        this.setCreatedAt(LocalDateTime.now());
    }

    public void deactive(final UpdateDirectorMasterRequest updateDirectorMasterRequest) {
        this.setEuid(updateDirectorMasterRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
