package com.ponsun.pep.pepDetails.AkaDet.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class AbstractAkaDetRequest {
    private Integer id;
    private Integer pepId;
    private String akaName;
    private Integer uid;
    private Integer euid;
}
