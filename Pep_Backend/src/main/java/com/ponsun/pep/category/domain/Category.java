package com.ponsun.pep.category.domain;

import com.ponsun.pep.category.request.CreateCategoryRequest;
import com.ponsun.pep.category.request.UpdateCategoryRequest;
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
@Tag(name = "pep_config_category")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static Category create(final CreateCategoryRequest createCategoryRequest){
        final Category category = new Category();
        category.setName(createCategoryRequest.getName());
        category.setUid(createCategoryRequest.getUid());
        category.setStatus(Status.ACTIVE);
        category.setCreatedAt(LocalDateTime.now());
        return category;
    }
    public void update(final UpdateCategoryRequest updateCategoryRequest){
        this.setName(updateCategoryRequest.getName());
        this.setEuid(updateCategoryRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
