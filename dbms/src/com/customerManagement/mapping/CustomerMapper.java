package com.customerManagement.mapping;

import com.customerManagement.entity.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Nurhasan
 */
public class CustomerMapper {
    public static CustomerDTO mapCustomer (ResultSet resultSet) throws SQLException {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(resultSet.getInt("customer_id"));
        customerDTO.setFirstName(resultSet.getString("first_name"));
        customerDTO.setLastName(resultSet.getString("last_name"));
        customerDTO.setEmailID(resultSet.getString("email"));
        customerDTO.setCity(resultSet.getString("city"));
        customerDTO.setState(resultSet.getString("state"));
        customerDTO.setSignUpDate((resultSet.getDate("signup_date").toLocalDate()));
        return customerDTO;
    }
}
