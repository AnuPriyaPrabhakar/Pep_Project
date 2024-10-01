package com.ponsun.pep.RequestDescription.domain;

import com.ponsun.pep.RequestDescription.request.CreateRequestDescriptionRequest;
import com.ponsun.pep.RequestDescription.request.UpdateRequestDescriptionRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_request_for_update_description")
public class RequestDescription extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name="description")
    private String description;

    @Column(name = "uid")
    private Integer uid;

    public static  RequestDescription create(final CreateRequestDescriptionRequest createRequestDescriptionRequest){
        final RequestDescription requestDescription = new RequestDescription();
        requestDescription.setPepId(createRequestDescriptionRequest.getPepId());
        requestDescription.setDescription(createRequestDescriptionRequest.getDescription());
        requestDescription.setUid(createRequestDescriptionRequest.getUid());
        requestDescription.setStatus(Status.ACTIVE);
        requestDescription.setCreatedAt(LocalDateTime.now());
        return requestDescription;
    }
    public void update(final UpdateRequestDescriptionRequest updateRequestDescriptionRequest){
        this.setPepId(updateRequestDescriptionRequest.getPepId());
        this.setDescription(updateRequestDescriptionRequest.getDescription());
//        this.setUid(updateRequestDescriptionRequest.getUid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
