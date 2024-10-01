package com.ponsun.pep.taskAssign.domain;

import com.ponsun.pep.taskAssign.request.CreateTaskAssignRequest;
import com.ponsun.pep.taskAssign.request.UpdateTaskAssignRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name ="pep_task_assign")
public class TaskAssign extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "assignTo")
    private Integer assignTo;

    @Column(name ="assignBy")
    private Integer assignBy;

    @Column(name ="countryId")
    private Integer countryId;

    @Column(name="stateId")
    private Integer stateId;

    @Column(name="year")
    private Integer year;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "edt")
    private Integer edt;

    @Column(name = "euid")
    private Integer euid;

    public static TaskAssign create(final CreateTaskAssignRequest createTaskAssignRequest){
        final TaskAssign taskAssign = new TaskAssign();
        taskAssign.setAssignTo(createTaskAssignRequest.getAssignTo());
        taskAssign.setAssignBy(createTaskAssignRequest.getAssignBy());
        taskAssign.setCountryId(createTaskAssignRequest.getCountryId());
        taskAssign.setStateId(createTaskAssignRequest.getStateId());
        taskAssign.setYear(createTaskAssignRequest.getYear());
        taskAssign.setUid(createTaskAssignRequest.getUid());
        taskAssign.setStatus(Status.ACTIVE);
        taskAssign.setCreatedAt(LocalDateTime.now());
        return taskAssign;
    }

    public void update(final UpdateTaskAssignRequest updateTaskAssignRequest) {
        this.setAssignTo(updateTaskAssignRequest.getAssignTo());
        this.setAssignBy(updateTaskAssignRequest.getAssignBy());
        this.setCountryId(updateTaskAssignRequest.getCountryId());
        this.setStateId(updateTaskAssignRequest.getStateId());
        this.setYear(updateTaskAssignRequest.getYear());
        this.setUid(updateTaskAssignRequest.getUid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }

}
