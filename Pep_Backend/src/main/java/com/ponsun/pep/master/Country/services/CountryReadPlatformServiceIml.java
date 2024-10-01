package com.ponsun.pep.master.Country.services;

import com.ponsun.pep.master.Country.domain.Country;
import com.ponsun.pep.master.Country.domain.CountryRepository;
import com.ponsun.pep.master.Country.domain.CountryRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryReadPlatformServiceIml implements CountryReadPlatformService {
    private final CountryRepositoryWrapper countryRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CountryRepository countryRepository;

    @Override
    public Country fetchCountryById(Integer id){

        return this.countryRepository.findById(id).get();

    }
    @Override
    public List<Country> fetchAllCountry(){
        return this.countryRepository.findAll();
    }
}
