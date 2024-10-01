package com.ponsun.pep.imageDet.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.imageDet.request.CreateImageDetRequest;
import com.ponsun.pep.imageDet.request.UpdateImageDetRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;


@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_image_det")
public class ImageDet extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "imageName")
    private String imageName;

    @Column(name = "file_type")
    private String file_type;

    @Column(name="imageMasterId")
    private Integer imageMasterId;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static ImageDet create(final CreateImageDetRequest createImageDetRequest) {
        final ImageDet imageDet = new ImageDet();
        imageDet.setPepId(createImageDetRequest.getPepId());
        imageDet.setImageName(createImageDetRequest.getImageName());
        imageDet.setFile_type(createImageDetRequest.getFile_type());
        imageDet.setImageMasterId(createImageDetRequest.getImageMasterId());
        imageDet.setUid(createImageDetRequest.getUid());
        imageDet.setStatus(Status.ACTIVE);
        imageDet.setCreatedAt(LocalDateTime.now());
        return imageDet;
    }
    public void update(final UpdateImageDetRequest updateImageDetRequest){
        this.setPepId(updateImageDetRequest.getPepId());
        this.setImageName(updateImageDetRequest.getImageName());
        this.setFile_type(updateImageDetRequest.getFile_type());
        this.setImageMasterId(updateImageDetRequest.getImageMasterId());
        this.setEuid(updateImageDetRequest.getEuid());
        this.setUpdatedAt(LocalDateTime.now());
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateImageDetRequest updateImageDetRequest){
        this.setEuid(updateImageDetRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}