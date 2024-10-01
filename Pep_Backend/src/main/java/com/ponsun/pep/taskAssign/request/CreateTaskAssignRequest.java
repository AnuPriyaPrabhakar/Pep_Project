package com.ponsun.pep.taskAssign.request;

import lombok.Data;

@Data
public class CreateTaskAssignRequest extends  AbstractTaskAssignBaseRequest {
    @Override
    public String toString(){ return super.toString();}
}
