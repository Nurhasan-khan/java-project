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
    private final static String DB_URL = System.getenv("DB_URL");
    private final static String DB_USER = System.getenv("DB_USER");
    private final static String DB_PASSWORD = System.getenv("DB_PASSWORD");
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

}

