package com.customerManagement.service;

import com.customerManagement.entity.CustomerDTO;
import com.customerManagement.exceptions.CustomerNotFoundException;
import com.customerManagement.exceptions.DuplicateCustomerException;
import com.customerManagement.repository.CustomerRepository;
import com.customerManagement.repository.CustomerRepositoryImpl;

import java.util.List;
import java.util.Optional;

/**
 * Nurhasan
 */
public non-sealed class  CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private static final String CUSTOMER_NOT_FOUND = "Customer not found.";
    private static final String CUSTOMER_ALREADY_EXISTS = "Customer already exists with same customerID.";
    public CustomerServiceImpl(){
        this.customerRepository = new CustomerRepositoryImpl();
    }
    @Override
    public void saveCustomer(CustomerDTO customerDTO) throws DuplicateCustomerException {
        Optional<CustomerDTO> existingCustomer = Optional.ofNullable(customerRepository.findCustomer(customerDTO.getId()));
        if(existingCustomer.isPresent())
            throw new DuplicateCustomerException(CUSTOMER_ALREADY_EXISTS);
        else
            customerRepository.saveCustomer(customerDTO);
    }

    @Override
    public CustomerDTO findCustomer(int id) throws CustomerNotFoundException {
        Optional<CustomerDTO> customerDTO = Optional.ofNullable(customerRepository.findCustomer(id));
        if(customerDTO.isPresent())
            return customerDTO.get();
        else
            throw new CustomerNotFoundException(CUSTOMER_NOT_FOUND);
    }

    @Override
    public void updateCustomerDetails(int id, String city , String state) throws CustomerNotFoundException {
        Optional<CustomerDTO> customerDTO = Optional.ofNullable(customerRepository.findCustomer(id));
        if(customerDTO.isPresent())
            customerRepository.updateCustomerDetails(id,city,state);
        else
            throw new CustomerNotFoundException(CUSTOMER_NOT_FOUND);

    }

    @Override
    public void deleteCustomer(int id) throws CustomerNotFoundException {

    }

    @Override
    public List<CustomerDTO> fetchAllCustomers() {
        return List.of();
    }

}
