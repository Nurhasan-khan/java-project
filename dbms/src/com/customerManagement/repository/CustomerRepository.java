package com.customerManagement.repository;

import com.customerManagement.entity.CustomerDTO;

import java.util.List;

public sealed interface CustomerRepository permits CustomerRepositoryImpl{
    void saveCustomer(CustomerDTO customerDTO);
    CustomerDTO findCustomer(int id);
    void updateCustomerDetails(int id, String city,String state);
    void deleteCustomer(int id);
    List<CustomerDTO> fetchAllCustomers();
}
