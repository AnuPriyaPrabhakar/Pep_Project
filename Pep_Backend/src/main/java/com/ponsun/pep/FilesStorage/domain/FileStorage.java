package com.ponsun.pep.FilesStorage.domain;

import com.ponsun.pep.FilesStorage.request.CreateFileStorageRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_config_attached_proof")

public class FileStorage extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    public static FileStorage create(final CreateFileStorageRequest createFileStorageRequest){
        final FileStorage fileStorage = new FileStorage();

       fileStorage.setName(createFileStorageRequest.getName());
       fileStorage.setUrl(createFileStorageRequest.getUrl());
       fileStorage.setStatus(Status.ACTIVE);
        return fileStorage;
    }


//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getUrl() {
//        return this.url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public long getId() {
//        return this.id;
//    }
}
