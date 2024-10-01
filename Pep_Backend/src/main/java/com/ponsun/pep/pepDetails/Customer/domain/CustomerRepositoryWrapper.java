package com.ponsun.pep.pepDetails.Customer.domain;

import com.ponsun.pep.master.Country.domain.Country;
import com.ponsun.pep.master.Country.domain.CountryRepository;
import com.ponsun.pep.pepDetails.Customer.request.AbstractCustomerRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerRepositoryWrapper extends AbstractCustomerRequest {
    private final CustomerRepository customerRepository;
    @Transactional
    public Customer findOneWithNotFoundDetection(final Integer id) {
        return this.customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
