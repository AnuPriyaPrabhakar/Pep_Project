package com.ponsun.pep.master.AssociatedList.domain;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import com.ponsun.pep.master.AssociatedList.request.CreateAssociatedListRequest;
import com.ponsun.pep.master.AssociatedList.request.UpdateAssociatedListRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_config_associated_list")
public class AssociatedList extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public static AssociatedList create(CreateAssociatedListRequest createAssociatedListRequest){
        final AssociatedList associatedList = new AssociatedList();
        associatedList.setName(createAssociatedListRequest.getName());
        associatedList.setStatus(Status.ACTIVE);
        associatedList.setCreatedAt(LocalDateTime.now());
        return associatedList;
    }
    public void update(final UpdateAssociatedListRequest updateAssociatedListRequest){
        this.setName(updateAssociatedListRequest.getName());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }


}
