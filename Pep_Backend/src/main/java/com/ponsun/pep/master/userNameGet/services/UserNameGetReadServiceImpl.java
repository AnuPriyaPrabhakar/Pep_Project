package com.ponsun.pep.master.userNameGet.services;

import com.ponsun.pep.Edit.QcView.data.QcViewData;
import com.ponsun.pep.Edit.QcView.rowmapper.QcViewRowMapper;
import com.ponsun.pep.master.userNameGet.data.UserNameGetData;
import com.ponsun.pep.master.userNameGet.rowmapper.UserNameGetRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserNameGetReadServiceImpl implements  UserNameGetReadService {

    private final UserNameGetRowMapper userNameGetRowMapper;
    private final JdbcTemplate jdbcTemplate;
        @Override
        public List<UserNameGetData> fetchAllUserNameGet() {
            String query = "SELECT a.full_name FROM admin_users a";
            return jdbcTemplate.query(query, userNameGetRowMapper);
        }
}

