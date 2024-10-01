package com.ponsun.pep.taskReassign.request;

import lombok.Data;

@Data
public class AbstractTaskReassignRequest {
    private Integer pepId;
    private Integer reassignByUid;
    private Integer reassignToUid;
    private String reassignDt;
    private Integer entryUid;
    private String entryDt;
    private Integer editUid;
    private String editDt;
    private Integer qcApproved;
    private Integer qcApprovedUid;
    private String qcApprovedDt;
    private Integer qcPending;
    private Integer qcPendingUid;
    private String qcPendingDt;
    private Integer qcView;
    private Integer qcViewUid;
    private String qcViewDt;
    private Integer qcEdit;
    private Integer qcEditUid;
    private String qcEditDt;
    private Integer managerView;
    private Integer managerViewUid;
    private String managerViewDt;
    private Integer managerPending;
    private Integer managerPendingUid;
    private String managerPendingDt;
    private Integer managerApprove;
    private Integer managerApproveUid;
    private String managerApproveDt;
    private Integer finalApprove;
    private Integer finalUid;
    private String finalApproveDt;
    private Integer published;
    private Integer publishedUid;
    private String publishedDt;
    private Integer active;
}
