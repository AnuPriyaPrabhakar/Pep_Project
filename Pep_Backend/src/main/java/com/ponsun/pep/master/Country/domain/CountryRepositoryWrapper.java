package com.ponsun.pep.master.Country.domain;

import com.ponsun.pep.master.Country.request.AbstractCountryRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountryRepositoryWrapper extends AbstractCountryRequest {
    private final CountryRepository countryRepository;
    @Transactional
    public Country findOneWithNotFoundDetection(final Integer id) {
        return this.countryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Country Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }

}

