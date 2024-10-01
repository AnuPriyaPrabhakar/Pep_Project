package com.ponsun.pep.master.Country.services;

import com.ponsun.pep.master.Country.domain.Country;

import java.util.List;

public interface CountryReadPlatformService {

    Country fetchCountryById(Integer id);

    List<Country> fetchAllCountry();
}
