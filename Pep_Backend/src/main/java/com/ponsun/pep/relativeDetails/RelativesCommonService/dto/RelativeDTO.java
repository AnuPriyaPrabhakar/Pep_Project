package com.ponsun.pep.relativeDetails.RelativesCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class RelativeDTO {
    private Integer id;
    private Integer pepId;
    private Integer relativeMasterId;
    private String relativeName;
    private String pan;
    private Integer uid;
    private Integer euid;
}
