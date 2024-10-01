package com.ponsun.pep.taskReassign.data;

import lombok.Data;

@Data
public class TaskReassignData {
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
    private String qcView;
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

    public TaskReassignData
            (final Integer pepId , final Integer reassignByUid , final Integer reassignToUid ,
             final String reassignDt , final Integer entryUid , final String entryDt , final Integer editUid ,
             final String editDt , final Integer qcApproved , final Integer qcApprovedUid , final String qcApprovedDt ,
             final Integer qcPending , final Integer qcPendingUid , final String qcPendingDt , final String qcView ,
             final Integer qcViewUid , final String qcViewDt , final Integer qcEdit , final Integer qcEditUid ,
             final String qcEditDt , final Integer managerView , final Integer managerViewUid , final String managerViewDt ,
             final Integer managerPending , final Integer managerPendingUid , final String managerPendingDt , final Integer managerApprove , final Integer managerApproveUid , final String managerApproveDt , final Integer finalApprove ,
             final Integer finalUid , final String finalApproveDt , final Integer published , final Integer publishedUid,
             final String publishedDt , final Integer active)

    {


        this.pepId = pepId;
        this.reassignByUid = reassignByUid;
        this.reassignToUid = reassignToUid;
        this.reassignDt = reassignDt;
        this.entryUid = entryUid;
        this.entryDt = entryDt;
        this.editUid = editUid;
        this.editDt = editDt;
        this.qcApproved = qcApproved;
        this.qcApprovedUid = qcApprovedUid;
        this.qcApprovedDt = qcApprovedDt;
        this.qcPending = qcPending;
        this.qcPendingUid = qcPendingUid;
        this.qcPendingDt = qcPendingDt;
        this.qcView = qcView;
        this.qcViewUid = qcViewUid;
        this.qcViewDt = qcViewDt;
        this.qcEdit = qcEdit;
        this.qcEditUid = qcEditUid;
        this.qcEditDt = qcEditDt;
        this.managerView = managerView;
        this.managerViewUid = managerViewUid;
        this.managerViewDt = managerViewDt;
        this.managerPendingDt = managerPendingDt;
        this.managerPendingUid = managerPendingUid;
        this.managerApprove = managerApprove;
        this.managerApproveUid = managerApproveUid;
        this.managerPending = managerPending;
        this.managerApproveDt = managerApproveDt;
        this.finalApprove = finalApprove;
        this.finalUid = finalUid;
        this.finalApproveDt = finalApproveDt;
        this.published = published;
        this.publishedUid = publishedUid;
        this.publishedDt = publishedDt;
        this.active = active;
    }
    public static TaskReassignData newInstance   (final Integer pepId , final Integer reassignByUid , final Integer reassignToUid ,
                                                  final String reassignDt , final Integer entryUid , final String entryDt , final Integer editUid ,
                                                  final String editDt , final Integer qcApproved , final Integer qcApprovedUid , final String qcApprovedDt ,
                                                  final Integer qcPending , final Integer qcPendingUid , final String qcPendingDt , final String qcView ,
                                                  final Integer qcViewUid , final String qcViewDt , final Integer qcEdit , final Integer qcEditUid ,
                                                  final String qcEditDt , final Integer managerView , final Integer managerViewUid , final String managerViewDt ,
                                                  final Integer managerPending , final Integer managerPendingUid , final String managerPendingDt , final Integer managerApprove , final Integer managerApproveUid , final String managerApproveDt , final Integer finalApprove ,
                                                  final Integer finalUid , final String finalApproveDt , final Integer published , final Integer publishedUid,
                                                  final String publishedDt , final Integer active) {
        return new TaskReassignData (pepId , reassignByUid , reassignToUid ,reassignDt ,
                entryUid , entryDt , editUid , editDt , qcApproved , qcApprovedUid , qcApprovedDt , qcPending ,
                qcPendingUid , qcPendingDt , qcView , qcViewUid , qcViewDt , qcEdit , qcEditUid , qcEditDt , managerView ,
                managerViewUid , managerViewDt , managerPending , managerPendingUid , managerPendingDt , managerApprove , managerApproveUid ,
                managerApproveDt , finalApprove , finalUid , finalApproveDt , published , publishedUid , publishedDt , active );
    }


}
