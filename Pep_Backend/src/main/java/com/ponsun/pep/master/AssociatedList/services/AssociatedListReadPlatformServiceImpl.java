package com.ponsun.pep.master.AssociatedList.services;

import com.ponsun.pep.master.AssociatedList.domain.AssociatedList;
import com.ponsun.pep.master.AssociatedList.domain.AssociatedListRepository;
import com.ponsun.pep.master.AssociatedList.domain.AssociatedListRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssociatedListReadPlatformServiceImpl implements AssociatedListReadPlatformService{
    private final AssociatedListRepositoryWrapper associatedListRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AssociatedListRepository associatedListRepository;

    @Override
    public AssociatedList fetchAssociatedListById(Integer id){
        return this.associatedListRepository.findById(id).get();
    }
    @Override
    public List<AssociatedList> fetchAllAssociatedList(){
        return this.associatedListRepository.findAll();
    }
}
