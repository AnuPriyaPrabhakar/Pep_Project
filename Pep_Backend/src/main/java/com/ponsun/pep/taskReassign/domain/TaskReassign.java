package com.ponsun.pep.taskReassign.domain;

import com.ponsun.pep.taskReassign.request.CreateTaskReassignRequest;
import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "pep_task_reassign_status")


public class TaskReassign extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pepId")
    private Integer pepId;

    @Column(name = "reassign_by_uid")
    private Integer reassignByUid;

    @Column(name = "reassign_to_uid")
    private Integer reassignToUid;

    @Column(name = "reassign_dt")
    private String reassignDt;

    @Column(name = "entry_uid")
    private Integer entryUid;

    @Column(name = "entry_dt")
    private String entryDt;

    @Column(name = "edit_uid")
    private Integer editUid;

    @Column(name = "edit_dt")
    private String editDt;

    @Column(name = "qc_approved")
    private Integer qcApproved;

    @Column(name = "qc_approved_uid")
    private Integer qcApprovedUid;

    @Column(name = "qc_approved_dt")
    private String qcApprovedDt;

    @Column(name = "qc_pending")
    private Integer qcPending;

    @Column(name = "qc_pending_uid")
    private Integer qcPendingUid;

    @Column(name = "qc_pending_dt")
    private String qcPendingDt;

    @Column(name = "qc_view")
    private Integer qcView;

    @Column(name = "qc_view_uid")
    private Integer qcViewUid;

    @Column(name = "qc_view_dt")
    private String qcViewDt;

    @Column(name = "qc_edit")
    private Integer qcEdit;

    @Column(name = "qc_edit_uid")
    private Integer qcEditUid;

    @Column(name = "qc_edit_dt")
    private String qcEditDt;

    @Column(name = "manager_view")
    private Integer managerView;

    @Column(name = "manager_view_uid")
    private Integer managerViewUid;

    @Column(name = "manager_view_dt")
    private String managerViewDt;

    @Column(name = "manager_pending")
    private Integer managerPending;

    @Column(name = "manager_pending_uid")
    private Integer managerPendingUid;

    @Column(name = "manager_pending_dt")
    private String managerPendingDt;

    @Column(name = "manager_approve")
    private Integer managerApprove;

    @Column(name = "manager_approve_uid")
    private Integer managerApproveUid;

    @Column(name = "manager_approve_dt")
    private String managerApproveDt;

    @Column(name = "final_approve")
    private Integer finalApprove;

    @Column(name = "final_uid")
    private Integer finalUid;

    @Column(name = "final_approve_dt")
    private String finalApproveDt;

    @Column(name = "published")
    private Integer published;

    @Column(name = "published_uid")
    private Integer publishedUid;

    @Column(name = "published_dt")
    private String publishedDt;

    @Column(name = "active")
    private Integer active;

    public static TaskReassign create (final CreateTaskReassignRequest createTaskReassignRequest) {
       final TaskReassign taskReassign = new TaskReassign();
       taskReassign.setPepId(createTaskReassignRequest.getPepId());
       taskReassign.setQcApproved(createTaskReassignRequest.getQcApproved());
       taskReassign.setQcPending(createTaskReassignRequest.getQcPending());
       taskReassign.setFinalApprove(createTaskReassignRequest.getFinalApprove());
       taskReassign.setReassignByUid(createTaskReassignRequest.getReassignByUid());
       taskReassign.setReassignToUid(createTaskReassignRequest.getReassignToUid());
       taskReassign.setReassignDt(createTaskReassignRequest.getReassignDt());
       taskReassign.setEntryDt(createTaskReassignRequest.getEntryDt());
       taskReassign.setEntryUid(createTaskReassignRequest.getEntryUid());
       taskReassign.setQcViewDt(createTaskReassignRequest.getQcViewDt());
       taskReassign.setQcEditDt(createTaskReassignRequest.getQcEditDt());
       taskReassign.setQcApproved(createTaskReassignRequest.getQcApproved());
       taskReassign.setQcApprovedDt(createTaskReassignRequest.getQcApprovedDt());
       taskReassign.setManagerView(createTaskReassignRequest.getManagerView());
       taskReassign.setManagerViewDt(createTaskReassignRequest.getManagerViewDt());
       taskReassign.setManagerPending(createTaskReassignRequest.getManagerPending());
       taskReassign.setFinalApproveDt(createTaskReassignRequest.getFinalApproveDt());
       taskReassign.setFinalUid(createTaskReassignRequest.getFinalUid());
       taskReassign.setPublished(createTaskReassignRequest.getPublished());
       taskReassign.setActive(createTaskReassignRequest.getActive());
       taskReassign.onCreate();
       taskReassign.setStatus(Status.ACTIVE);
       return taskReassign;
   }

    public static TaskReassign createtask(final Integer pepId, final Integer entryUid) {
        final TaskReassign taskReassign = new TaskReassign();
        taskReassign.setPepId(pepId);
        taskReassign.setEntryDt(String.valueOf(LocalDateTime.now()));
        taskReassign.setEntryUid(entryUid);
        taskReassign.onCreate();
        taskReassign.setStatus(Status.ACTIVE);
        return taskReassign;
    }

    public void entryUpdate(final Integer uid, String status) {
        if (status.equals("DataEntry")) {
            this.setEntryUid(uid);
            this.setEntryDt(String.valueOf(LocalDateTime.now()));
            this.onUpdate();
        }
        if (status.equals("QcView")) {
            this.setQcViewUid(uid);
            this.setQcViewDt(String.valueOf(LocalDateTime.now()));
            this.onUpdate();
        }

        if (status.equals("QcEdit")) {
            this.setQcEditUid(uid);
            this.setQcEditDt(String.valueOf(LocalDateTime.now()));
            this.onUpdate();
        }
        if (status.equals("ManagerApprove")) {
            this.setManagerApproveUid(uid);
            this.setManagerApproveDt(String.valueOf(LocalDateTime.now()));
            this.onUpdate();
        }

        if (status.equals("ManagerPending")) {
            this.setManagerApproveUid(uid);
            this.setManagerApproveDt(String.valueOf(LocalDateTime.now()));
            this.onUpdate();
        }

        if (status.equals("QcPending")) {
            this.setQcPendingUid(uid);
            this.setQcPendingDt(String.valueOf(LocalDateTime.now()));
            this.onUpdate();
        }

        if (status.equals("Published")) {
            this.setPublishedUid(uid);
            this.setPublishedDt(String.valueOf(LocalDateTime.now()));
            this.onUpdate();
        }
        if (status.equals("ReAssign")) {
            this.setReassignByUid(uid);
            this.setReassignToUid(uid);
            this.setReassignDt(String.valueOf(LocalDateTime.now()));
            this.onUpdate();
        }
    }
}
//   public void update (final UpdateTaskReassignRequest updateTaskReassignRequest) {
//       this.setPepId(updateTaskReassignRequest.getPepId());
//       this.setQcApproved(updateTaskReassignRequest.getQcApproved());
//       this.setQcPending(updateTaskReassignRequest.getQcPending());
//       this.setFinalApprove(updateTaskReassignRequest.getFinalApprove());
//       this.setReassignByUid(updateTaskReassignRequest.getReassignByUid());
//       this.setReassignToUid(updateTaskReassignRequest.getReassignToUid());
//       this.setReassignDt(updateTaskReassignRequest.getReassignDt());
//       this.setEntryDt(updateTaskReassignRequest.getEntryDt());
//       this.setEntryUid(updateTaskReassignRequest.getEntryUid());
//       this.setQcViewDt(updateTaskReassignRequest.getQcViewDt());
//       this.setQcEditDt(updateTaskReassignRequest.getQcEditDt());
//       this.setQcApproved(updateTaskReassignRequest.getQcApproved());
//       this.setQcApprovedDt(updateTaskReassignRequest.getQcApprovedDt());
//       this.setManagerView(updateTaskReassignRequest.getManagerView());
//       this.setManagerViewDt(updateTaskReassignRequest.getManagerViewDt());
//       this.setManagerPending(updateTaskReassignRequest.getManagerPending());
//       this.setFinalApproveDt(updateTaskReassignRequest.getFinalApproveDt());
//       this.setManagerUid(updateTaskReassignRequest.getManagerUid());
//       this.setQcUid(updateTaskReassignRequest.getQcUid());
//       this.setFinalUid(updateTaskReassignRequest.getFinalUid());
//       this.setPublished(updateTaskReassignRequest.getPublished());
//       this.setPublishedDt(updateTaskReassignRequest.getPublishedDt());
//       this.setActive(updateTaskReassignRequest.getActive());
//       this.onUpdate();
//       this.setStatus(Status.ACTIVE);
//
//   }

//}