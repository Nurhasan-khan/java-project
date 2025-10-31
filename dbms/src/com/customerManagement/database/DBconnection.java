package com.customerManagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Supplier;

/**
 * @author Nurhasan
 */
public class DBconnection {
    private final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String DB_URL = "jdbc:mysql://localhost:3306/online_store";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "Nurhasan@06";
    private static Properties dbProperties;


    public static Supplier<Connection> getSupplierConnection = () -> {
        try {
            Class.forName(DB_DRIVER);
            dbProperties = new Properties();
            dbProperties.put("user",DB_USER);
            dbProperties.put("password",DB_PASSWORD);
            return
                    DriverManager.getConnection(DB_URL, dbProperties);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            dbProperties.clear();
        }
    };

    private DBconnection() {

    }

//    public static Connection getConnection() {
//        Connection connection = null;
//        Properties dbProperties = new Properties();
//        dbProperties.put("user", DB_USER);
//        dbProperties.put("password", DB_PASSWORD);
//        try {
//            Class.forName(DB_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, dbProperties);
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println(e.getMessage());
//            return null;
//        } finally {
//            dbProperties.clear();
//        }
//        return connection;
//    }
}

