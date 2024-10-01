package com.ponsun.pep.master.designation.services;



import com.ponsun.pep.master.designation.domain.Designation;

import java.util.List;

public interface DesignationReadPlatformService {
    List<Designation> fetchAllDesignation();

    Designation fetchDesignationById(Integer id);
}
