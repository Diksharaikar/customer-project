//package com.cp;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class MySQLConnection {
//
//    private final String jdbcUrl = "jdbc:mysql://localhost:3306/CUSTOMER_DB";
//    private final String username = "root";
//    private final String password = "q1";
//
//    private Connection connection;
//
//    public void initConnection() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Create a connection to the database
//            connection = DriverManager.getConnection(jdbcUrl, username, password);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void closeConnection() {
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public List<Customer> getCustomers() {
//        try {
//            // Check if the connection is successful
//            if (connection != null) {
//
//                Statement statement = connection.createStatement();
//                String sqlQuery = "SELECT * FROM customer";
//
//                ResultSet resultSet = statement.executeQuery(sqlQuery);
//
//                List<Customer> customers = new ArrayList<>();
//                ObjectMapper objectMapper = new ObjectMapper();
//
//                while (resultSet.next()) {
//                   // Customer customer = mapResultSetToCustomer(resultSet);
//                   // customers.add(customer);
//                }
//
//                resultSet.close();
//                statement.close();
//                return customers;
//            } else {
//                throw new RuntimeException("Failed to connect to the database.");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Database connection error: " + e.getMessage());
//        }
//    }
//
//
////    private static Customer mapResultSetToCustomer(ResultSet resultSet) throws SQLException {
////        Customer customer = new Customer(resultSet.getString("customer_id"),
////                resultSet.getString("customer_fName"),
////                resultSet.getString("customer_mName"),
////                resultSet.getString("customer_lName"),
////                resultSet.getInt("customer_mobile"),
////                resultSet.getString("customer_email"),
////                resultSet.getString("customer_lAddress"),
////                resultSet.getString("customer_lAddress_dist"),
////                resultSet.getString("customer_lAddress_state"),
////                resultSet.getString("customer_lAddress_country"),
////                resultSet.getString("customer_pAddress"),
////                resultSet.getString("customer_pAddress_dist"),
////                resultSet.getString("customer_pAddress_state"),
////                resultSet.getString("customer_pAddress_country"),
////                CustomerStatus.valueOf(resultSet.getString("customer_status"))
////                );
////        return customer;
////    }
//}
