package com.ponsun.pep.master.AssociatedList.services;


import com.ponsun.pep.master.AssociatedList.domain.AssociatedList;
import java.util.List;

public interface AssociatedListReadPlatformService {
    AssociatedList fetchAssociatedListById(Integer id);
    List<AssociatedList> fetchAllAssociatedList();
}
