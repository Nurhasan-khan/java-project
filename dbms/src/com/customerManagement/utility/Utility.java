package com.customerManagement.utility;
import com.customerManagement.entity.CustomerDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utility {
    private Utility(){

    }
    public static int getMenuOption(Scanner scan) {
        System.out.println("----Welcome To C-Track----");
        System.out.println("Press 1. To Save Customer Details");
        System.out.println("Press 2. To Find Customer Details");
        System.out.println("Press 3. To update Customer Details");
        System.out.println("Press 4. To Delete a Customer");
        System.out.println("Press 5. To Fetch All Customers");
        int menuOption = scan.nextInt();
        if (menuOption == 1 || menuOption == 2 || menuOption == 3 || menuOption == 4 || menuOption == 5) {
            return menuOption;
        } else {
            System.out.println("Please enter a valid option!!");
            return getMenuOption(scan);
        }
    }
    public static boolean wantToContinue(Scanner scan){
        System.out.println("Do You Want to Continue? (Y/N): ");
        char choice = scan.next().toUpperCase().charAt(0);
        return 'Y' == choice;
    }
    public static CustomerDTO acceptCustomerDetails(Scanner scanner){
        try {
            Pattern emailPattern = Pattern.compile("^[A-za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
            System.out.println("Enter Customer id: ");
            int id = scanner.nextInt();
            System.out.println("Enter Customer's First Name: ");
            String firstName = scanner.next();
            System.out.println("Enter Customer's Last Name: ");
            String lastName = scanner.next();
            System.out.println("Enter Customer's Email-ID: ");
            scanner.nextLine();
            String emailID = scanner.nextLine();
            if (emailID.matches(String.valueOf(emailPattern))) {
            } else
                throw new InputMismatchException("Enter a valid email-id!!");
            System.out.println("Enter Customer's City: ");
            String city = scanner.nextLine();
            System.out.println("Enter Customer's State: ");
            String state = scanner.nextLine().toUpperCase();
            System.out.println("Enter SignUp-Date: ");
            String date = scanner.nextLine();
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setId(id);
                customerDTO.setFirstName(firstName);
                customerDTO.setLastName(lastName);
                customerDTO.setEmailID(emailID);
                customerDTO.setCity(city);
                customerDTO.setState(state);
                customerDTO.setSignUpDate(dateConverter(date));
                return customerDTO;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return acceptCustomerDetails(scanner);
        }
    }
    private static LocalDate dateConverter(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(str,formatter);
    }
}
