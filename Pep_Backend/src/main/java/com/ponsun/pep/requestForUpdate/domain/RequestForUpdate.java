package com.ponsun.pep.requestForUpdate.domain;


import com.ponsun.pep.requestForUpdate.request.CreateRequestForUpdateRequest;
import com.ponsun.pep.requestForUpdate.request.UpdateRequestForUpdateRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_request_for_update")
public class RequestForUpdate extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "requestAt")
    private String requestAt;

    @Column(name = "requestUid")
    private Integer requestUid;

    @Column(name = "updatedUid")
    private Integer updatedUid;

    @Column(name = "valid")
    private Integer valid;

    @Column(name = "updated")
    private String updated;

    @Column(name = "requestForUpdate")
    private String requestForUpdate;


    public static RequestForUpdate create (final CreateRequestForUpdateRequest createRequestForUpdateRequest) {
        final RequestForUpdate requestForUpdate = new RequestForUpdate();
        requestForUpdate.setPepId(createRequestForUpdateRequest.getPepId());
        requestForUpdate.setRequestAt(createRequestForUpdateRequest.getRequestAt());
        requestForUpdate.setRequestUid(createRequestForUpdateRequest.getRequestUid());
        requestForUpdate.setUpdatedUid(createRequestForUpdateRequest.getUpdatedUid());
        requestForUpdate.setValid(createRequestForUpdateRequest.getValid());
        requestForUpdate.setUpdated(createRequestForUpdateRequest.getUpdated());
        requestForUpdate.setRequestForUpdate(createRequestForUpdateRequest.getRequestForUpdate());
        requestForUpdate.setStatus(Status.ACTIVE);
        requestForUpdate.onCreate();
        return requestForUpdate;
    }

    public void  update (final UpdateRequestForUpdateRequest updateRequestForUpdateRequest) {
        this.setPepId(updateRequestForUpdateRequest.getPepId());
        this.setRequestAt(updateRequestForUpdateRequest.getRequestAt());
        this.setRequestUid(updateRequestForUpdateRequest.getRequestUid());
        this.setUpdatedUid(updateRequestForUpdateRequest.getUpdatedUid());
        this.setValid(updateRequestForUpdateRequest.getValid());
        this.setUpdated(updateRequestForUpdateRequest.getUpdated());
        this.setRequestForUpdate(updateRequestForUpdateRequest.getRequestForUpdate());
        this.setStatus(Status.ACTIVE);
        this.onUpdate();
    }

}
