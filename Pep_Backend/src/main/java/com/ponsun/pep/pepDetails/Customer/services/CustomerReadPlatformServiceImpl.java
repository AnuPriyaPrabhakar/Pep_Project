package com.ponsun.pep.pepDetails.Customer.services;

import com.ponsun.pep.master.Country.domain.Country;
import com.ponsun.pep.master.Country.domain.CountryRepository;
import com.ponsun.pep.master.Country.domain.CountryRepositoryWrapper;
import com.ponsun.pep.pepDetails.Customer.domain.Customer;
import com.ponsun.pep.pepDetails.Customer.domain.CustomerRepository;
import com.ponsun.pep.pepDetails.Customer.domain.CustomerRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerReadPlatformServiceImpl implements CustomerReadPlatformService{
    private final CustomerRepositoryWrapper customerRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CustomerRepository customerRepository;

    @Override
    public Customer fetchCustomerById(Integer id){
        return this.customerRepository.findById(id).get();

    }
    @Override
    public List<Customer> fetchAllCustomer(){
        return this.customerRepository.findAll();
    }
}
