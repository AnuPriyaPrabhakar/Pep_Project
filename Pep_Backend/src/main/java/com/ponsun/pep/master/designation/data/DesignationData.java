package com.ponsun.pep.master.designation.data;

import lombok.Data;

@Data
public class DesignationData {
    private Integer id;
    private String name;
    public DesignationData(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static DesignationData newInstance(final Integer id, final String name, final String dt, final Boolean valid) {
        return new DesignationData(id, name);
    }
}

