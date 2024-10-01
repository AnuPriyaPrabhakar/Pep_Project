//package com.ponsun.pep.TaskReassign.rowmapper;
//
//import com.ponsun.pep.TaskReassign.data.TaskReassignData;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class TaskReassignRowMapper implements RowMapper<TaskReassignData> {
///*    private final String schema;
//
//    public TaskReassignRowMapper(){
//        final StringBuilder builder = new StringBuilder(200);
//        builder.append("FROM  Table: pep_task_reassign_status task");
//        this.schema = builder.toString();
//    }
//
//    public String tableSchema(){
//        final StringBuilder builder = new StringBuilder(200);
//        builder.append("task.pepId as pepId");
//        builder.append("task.qcApproved as qcApproved");
//        builder.append("task.qcPending as qcPending");
//        builder.append("task.finalApprove as finalApprove");
//        builder.append("task.reassignByUid as reassignByUid");
//        builder.append("task.reassignToUid as reassignToUid");
//        builder.append("task.reassignDt as reassignDt");
//        builder.append("task.entryDt as entryDt");
//        builder.append("task.entryUid as entryUid");
//        builder.append("task.qcViewDt as qcViewDt");
//        builder.append("task.qcEditDt as qcEditDt");
//        builder.append("task.qcApprovedDt as qcApprovedDt");
//        builder.append("task.managerView as managerView");
//        builder.append("task.managerViewDt as managerViewDt");
//        builder.append("task.managerPending as managerPending");
//        builder.append("task.managerPendingDt as managerPendingDt");
//        builder.append("task.finalApproveDt as finalApproveDt");
//        builder.append("task.managerUid as managerUid");
//        builder.append("task.qcUid as qcUid");
//        builder.append("task.finalUid as finalUid");
//        builder.append("task.published as published");
//        builder.append("task.publishedDt as publishedDt");
//        builder.append("task.active as active");
//        builder.append(this.schema);
//        return builder.toString();
//    }
//
//    @Override
//    public TaskReassignData mapRow(ResultSet rs, int rowNum) throws SQLException {
//        final Integer pepId = rs.getInt("pepId");
//        final Integer qcApproved = rs.getInt("qcApproved");
//        final Integer qcPending = rs.getInt("qcPending");
//        final Integer finalApprove = rs.getInt("finalApprove");
//        final Integer reassignByUid = rs.getInt("reassignByUid");
//        final Integer reassignToUid = rs.getInt("reassignToUid");
//        final String reassignDt = rs.getString("reassignDt");
//        final String entryDt = rs.getString("entryDt");
//        final Integer entryUid = rs.getInt("entryUid");
//        final String qcViewDt = rs.getString("qcViewDt");
//        final String qcEditDt = rs.getString("qcEditDt");
//        final String qcApprovedDt = rs.getString("qcApprovedDt");
//        final Integer managerView = rs.getInt("managerView");
//        final String managerViewDt = rs.getString("managerViewDt");
//        final Integer managerPending = rs.getInt("managerPending");
//        final String managerPendingDt = rs.getString("managerPendingDt");
//        final String finalApproveDt = rs.getString("finalApproveDt");
//        final Integer managerUid = rs.getInt("managerUid");
//        final Integer qcUid = rs.getInt("qcUid");
//        final Integer finalUid = rs.getInt("finalUid");
//        final Integer published = rs.getInt("published");
//        final Integer publishedDt = rs.getInt("publishedDt");
//        final Integer active = rs.getInt("active");
//       return new TaskReassignData(pepId , qcApproved ,
//                qcPending , finalApprove , reassignByUid , reassignToUid , reassignDt , entryDt ,
//               entryUid , qcViewDt , qcEditDt , qcApprovedDt , managerView , managerViewDt , managerPending,
//               managerPendingDt , finalApproveDt , managerUid , qcUid , finalUid ,  published , publishedDt,active);
//    }*/
//}
//
