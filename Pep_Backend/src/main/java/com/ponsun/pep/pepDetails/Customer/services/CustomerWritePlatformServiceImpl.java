package com.ponsun.pep.pepDetails.Customer.services;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Customer.domain.Customer;
import com.ponsun.pep.pepDetails.Customer.domain.CustomerRepository;
import com.ponsun.pep.pepDetails.Customer.domain.CustomerRepositoryWrapper;
import com.ponsun.pep.pepDetails.Customer.request.CreateCustomerRequest;
import com.ponsun.pep.pepDetails.Customer.request.UpdateCustomerRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerWritePlatformServiceImpl implements CustomerWritePlatformService {
    private final CustomerRepository customerRepository;
    private final CustomerRepositoryWrapper customerRepositoryWrapper;



    @Override
    @Transactional
    public Response createCustomer(CreateCustomerRequest createCustomerRequest) {
        try {
            String pan = createCustomerRequest.getPan();
            if (pan != null && !pan.isEmpty()) {
                if (customerRepository.existsByPan(pan)) {
                    throw new EQAS_PEP_AppicationException("Customer with PAN already exists");
                }
            }
            final Customer customer = Customer.create(createCustomerRequest);
            this.customerRepository.saveAndFlush(customer);
            System.out.println("customer: " + customer);
            return Response.of(Integer.valueOf(customer.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateCustomer(Integer id, UpdateCustomerRequest updateCustomerRequest) {
        try {
            System.out.println("updateCustomerRequest: " + updateCustomerRequest);
            Customer customer = this.customerRepositoryWrapper.findOneWithNotFoundDetection(id);
            customer.setName(updateCustomerRequest.getName());
            customer.setSourceLink(updateCustomerRequest.getSourceLink());
            customer.setGenderId(updateCustomerRequest.getGenderId());
            customer.setEducation(updateCustomerRequest.getEducation());
            customer.setPlaceOfBirth(updateCustomerRequest.getPlaceOfBirth());
            customer.setEducation(updateCustomerRequest.getEducation());
            customer.setDob(updateCustomerRequest.getDob());
            customer.setPan(updateCustomerRequest.getPan());
            customer.setDirectorsIdentificationNumber(updateCustomerRequest.getDirectorsIdentificationNumber());
            customer.setAdverseInformation(updateCustomerRequest.getAdverseInformation());
            customer.setRegulatoryAction(updateCustomerRequest.getRegulatoryAction());
            this.customerRepository.saveAndFlush(customer);
            return Response.of(Long.valueOf(customer.getId()));


        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }


    //    @Override
//    @Transactional
//    public Response deactive(Integer pepId, Integer euid){
//        try{
//            List<Customer> customers = this.customerRepositoryWrapper.findOnePepIdWithNotFoundDetection(pepId);
//            Response response = null;
//            for (Customer customer : customers) {
//                customer.setEuid(euid);
//                customer.setStatus(Status.ACTIVE);
//                customer.setUpdatedAt(LocalDateTime.now());
//                response = Response.of(customer.getId());
//            }
//            return response;
//        }catch (DataIntegrityViolationException e){
//            throw new EQAS_PEP_AppicationException(e.getMessage());
//        }
//    }
    @Override
    @Transactional
    public Response deleteCustomer(Integer id) {
        try {
            Optional<Customer> optionalCustomer = customerRepository.findById(id);
            if (optionalCustomer.isPresent()) {
                customerRepository.delete(optionalCustomer.get());
                return Response.of(Long.valueOf(id));
            } else {
                throw new EntityNotFoundException("Customer not found with ID: " + id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Override
    public Response checked(String checked) {
        try {
            final Customer customer = new Customer();
            if (checked.equals("RegulatoryAction")) {
                customer.setRegulatoryAction(1);
                customer.onUpdate();
            }
            if (checked.equals("AdverseInformation")) {
                customer.setAdverseInformation(1);
                customer.onUpdate();
            }
            this.customerRepository.saveAndFlush(customer);
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
        return null;
    }
}

