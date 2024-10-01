package com.ponsun.pep.getDirectors.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.getDirectors.request.CreateGetDirectorsRequest;
import com.ponsun.pep.getDirectors.request.UpdateGetDirectorsRequest;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name="pep_directors_log")
public class GetDirectors extends BaseEntity {
    private static final long serialVersioUID = 1L;

    @Id
    @Column(name ="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="pan")
    private String pan;

    @Column(name="name")
    private String name;

    @Column(name="uid")
    private Integer uid;

    @Column(name="euid")
    private Integer euid;

    public static  GetDirectors create(final CreateGetDirectorsRequest createGetDirectorsRequest){
        final GetDirectors getDirectors = new GetDirectors();
        getDirectors.setName(createGetDirectorsRequest.getName());
        getDirectors.setPan(createGetDirectorsRequest.getPan());
        getDirectors.setUid(createGetDirectorsRequest.getUid());
        getDirectors.setStatus(Status.ACTIVE);
        getDirectors.setCreatedAt(LocalDateTime.now());
        return getDirectors;
    }
    public void update(final UpdateGetDirectorsRequest updateGetDirectorsRequest){
        this.setName(updateGetDirectorsRequest.getName());
        this.setPan(updateGetDirectorsRequest.getPan());
        this.setEuid(updateGetDirectorsRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
