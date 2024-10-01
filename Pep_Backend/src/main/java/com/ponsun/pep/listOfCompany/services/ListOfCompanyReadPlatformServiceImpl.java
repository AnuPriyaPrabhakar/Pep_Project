package com.ponsun.pep.listOfCompany.services;

import com.ponsun.pep.listOfCompany.domain.ListOfCompany;
import com.ponsun.pep.listOfCompany.domain.ListOfCompanyRepository;
import com.ponsun.pep.listOfCompany.domain.ListOfCompanyRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ListOfCompanyReadPlatformServiceImpl implements ListOfCompanyReadPlatformService{
    private final ListOfCompanyRepositoryWrapper listOfCompanyRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final ListOfCompanyRepository listOfCompanyRepository;

    @Override
    public ListOfCompany fetchListOfCompanyById(Integer id){
        return this.listOfCompanyRepository.findById(id).get();
    }
    @Override
    public List<ListOfCompany> fetchAllListOfCompany() { return this.listOfCompanyRepository.findAll();}
}
