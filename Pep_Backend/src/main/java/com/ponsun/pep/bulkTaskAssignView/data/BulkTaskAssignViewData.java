package com.ponsun.pep.bulkTaskAssignView.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BulkTaskAssignViewData {

    private Integer uid;
    private String searchName;
    private String userName;
    public BulkTaskAssignViewData (Integer uid, String searchName , String userName ) {
        this.uid = uid;
        this.searchName = searchName;
        this.userName = userName;
    }

    public static BulkTaskAssignViewData newInstance (Integer uid,String searchName , String userName ) {
        return new BulkTaskAssignViewData(uid , searchName , userName);
    }
}
