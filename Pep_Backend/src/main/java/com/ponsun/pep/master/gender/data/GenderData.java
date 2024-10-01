package com.ponsun.pep.master.gender.data;

import lombok.Data;

@Data
public class GenderData {
    private Integer id;
    private String gender;
    private Boolean valid;

    public GenderData(final Integer id, final String gender, final Boolean valid) {

        this.id = id;
        this.gender = gender;
        this.valid = valid;

    }

    public static GenderData newInstance(final Integer id, final String gender, final Boolean valid) {
        return new GenderData(id, gender, valid);
    }
}
