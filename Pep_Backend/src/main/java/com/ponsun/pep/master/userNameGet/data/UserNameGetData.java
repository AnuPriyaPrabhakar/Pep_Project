package com.ponsun.pep.master.userNameGet.data;

import lombok.Data;

@Data
public class UserNameGetData {

    private String full_name;

    public UserNameGetData (final String full_name) {
        this.full_name = full_name;
    }


    public static UserNameGetData newInstance (final String full_name) {
        return new UserNameGetData(full_name);
    }
}
