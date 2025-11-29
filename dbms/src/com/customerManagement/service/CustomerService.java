package com.customerManagement.service;

import com.customerManagement.entity.CustomerDTO;
import com.customerManagement.exceptions.CustomerNotFoundException;
import com.customerManagement.exceptions.DuplicateCustomerException;

import java.util.List;

/**
 * Nurhasan
 */
public sealed interface CustomerService permits CustomerServiceImpl {
    void saveCustomer(CustomerDTO customerDTO) throws DuplicateCustomerException;
    CustomerDTO findCustomer(int id) throws CustomerNotFoundException;
    void updateCustomerDetails(int id, String city, String state) throws CustomerNotFoundException;
    void deleteCustomer(int id) throws CustomerNotFoundException;
    List<CustomerDTO> fetchAllCustomers();
}
