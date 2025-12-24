package com.customerManagement;

import com.customerManagement.database.DBconnection;
import com.customerManagement.entity.CustomerDTO;
import com.customerManagement.service.CustomerService;
import com.customerManagement.service.CustomerServiceImpl;
import com.customerManagement.utility.Utility;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CTrack {
    public static void main(String[] args) throws SQLException {
        CTrack main = new CTrack();
        main.run();
        Connection con = DBconnection.getSupplierConnection.get();
//        System.out.println(con.getMetaData().getSQLKeywords());
        con.close();
    }
    private void run(){
        CustomerService customerService = new CustomerServiceImpl();
       try(Scanner scan = new Scanner(System.in)){
           do{
               System.out.println("----- Customer Management -----");
               int menuOption = Utility.getMenuOption(scan);
               switch (menuOption){
                   case 1 ->{
                       System.out.println("---- Save Customer Details ----");
                       CustomerDTO customerDTO = Utility.acceptCustomerDetails(scan);
                       customerService.saveCustomer(customerDTO);
                       System.out.println("Customer Details Saved Successfully!!");
                   }
                   case 2 ->{
                       System.out.println("---- Find Customer Details ----");
                       System.out.println("Enter Customer ID to Find: ");
                       int id = scan.nextInt();
                       CustomerDTO customerDTO = customerService.findCustomer(id);
                       System.out.println("Customer Details Found: " + customerDTO);
                   }
                   case 3 ->{
                       System.out.println("---- Update Customer Details ----");
                       System.out.println("Enter customer ID: ");
                       int id = scan.nextInt();
                       scan.nextLine();
                       System.out.println("Enter Customer's new city: ");
                       String city = scan.nextLine();
                       System.out.println("Enter Customer's new State: ");
                       String state = scan.nextLine();
                       customerService.updateCustomerDetails(id,city,state);
                       System.out.println("Information Updated Successfully.");
                   }
               }


           }while(Utility.wantToContinue(scan));
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }

    }
}
