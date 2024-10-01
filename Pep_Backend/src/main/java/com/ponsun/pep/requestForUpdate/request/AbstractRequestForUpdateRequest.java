package com.ponsun.pep.requestForUpdate.request;

import lombok.Data;

@Data
public class AbstractRequestForUpdateRequest {
    private Integer pepId;
    private String requestAt;
    private Integer requestUid;
    private Integer updatedUid;
    private Integer valid;
    private String updated;
    private String requestForUpdate;
}
