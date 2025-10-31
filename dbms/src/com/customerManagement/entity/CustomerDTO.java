package com.customerManagement.entity;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Nurhasan
 */
@Getter
@Setter
@ToString
public class CustomerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String emailID;
    private String city;
    private String state;
    private LocalDate SignUpDate;

}
