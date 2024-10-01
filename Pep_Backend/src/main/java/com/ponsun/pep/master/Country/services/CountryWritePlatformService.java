package com.ponsun.pep.master.Country.services;

import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.master.Country.request.CreateCountryRequest;
import com.ponsun.pep.master.Country.request.UpdateCountryRequest;

public interface CountryWritePlatformService {
    Response createCountry(CreateCountryRequest createCountryRequest);
    Response updateCountry(Integer id, UpdateCountryRequest updateCountryRequest);
    Response blockCountry(Integer id);
    Response unblockCountry(Integer id);

}
