package com.customerManagement.repository;

import com.customerManagement.database.DBconnection;
import com.customerManagement.entity.CustomerDTO;
import com.customerManagement.mapping.CustomerMapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

public final class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        String query = """
                INSERT INTO customers (customer_id, first_name, last_name, email, city, state, signup_date)
                VALUES (?,?,?,?,?,?,?);
                """;
        try(Connection connection = DBconnection.getSupplierConnection.get();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,customerDTO.getId());
            preparedStatement.setString(2,customerDTO.getFirstName());
            preparedStatement.setString(3,customerDTO.getLastName());
            preparedStatement.setString(4,customerDTO.getEmailID());
            preparedStatement.setString(5,customerDTO.getCity());
            preparedStatement.setString(6,customerDTO.getState());
            preparedStatement.setDate(7, Date.valueOf(customerDTO.getSignUpDate()));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerDTO findCustomer(int id) {
        CustomerDTO customerDTO = null;
        String query = "SELECT * FROM customers WHERE customer_id = ?";
        try(Connection connection = DBconnection.getSupplierConnection.get();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            var resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                customerDTO = CustomerMapper.mapCustomer(resultSet);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customerDTO;
    }

    @Override
    public void updateCustomerDetails(int id, String... args) {

    }

    @Override
    public void deleteCustomer(int id) {

    }

    @Override
    public List<CustomerDTO> fetchAllCustomers() {
        return List.of();
    }
}
