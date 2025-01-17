package com.cars24.dao.impl;

import com.cars24.dao.CustomersDao;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.util.DbUtil;

import java.sql.*;

public class CustomerDaoImpl implements CustomersDao {
    Connection connection = DbUtil.getDbConnection();
    private final static String SUCCESS_MESSAGE = "Customer added successfully";
    private final static String ERROR_MESSAGE = "Error while adding customer";
//    @Override
//    public String createCustomer(String name, String phone, String email, String address) {
//        // Constructing the SQL query dynamically (not recommended but per your preference)
//        String insertSQL = "INSERT INTO customers (name, phone, email, address) VALUES ("
//                + "'" + name + "', "
//                + "'" + phone + "', "
//                + "'" + email + "', "
//                + "'" + address + "'"
//                + ");";
//
////        System.out.println(insertSQL); // Debugging output
//
//        // Get the database connection
////        Connection connection = DbUtil.getDbConnection();
//
//        try {
//            // Create a statement and execute the query
//            Statement statement = connection.createStatement();
//            int rowsInserted = statement.executeUpdate(insertSQL);
////            System.out.println(rowsInserted + " row(s) inserted.");
//            return rowsInserted > 0 ? "Customer created successfully." : "Failed to create customer.";
//        } catch (Exception e) {
////            System.out.println("Error while inserting data into customers table");
//            e.printStackTrace();
//            return "Error occurred: " + e.getMessage();
//        } finally {
//            // Close the connection explicitly if try-with-resources is not used
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (Exception e) {
//                System.out.println("Error while inserting data into customers table");
//                e.printStackTrace();
//            }
//        }
//    }


    @Override
    public String createCustomer(AddCustomerReq addCustomerReq){
        String insertSQL = "INSERT INTO customers(name, phone, email, address) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

            preparedStatement.setString(1, addCustomerReq.getName()); //refers to first ?
            preparedStatement.setString(2, addCustomerReq.getPhone());
            preparedStatement.setString(3, addCustomerReq.getEmail());
            preparedStatement.setString(4, addCustomerReq.getAddress());

            int rowsInserted = preparedStatement.executeUpdate();
//            System.out.println(rowsInserted + " row(s) inserted.");
            return SUCCESS_MESSAGE;
        } catch (SQLException e) {
//            System.out.println("Error while inserting data into customers table");
//            e.printStackTrace();
            return ERROR_MESSAGE;
        }
//        return "";
    }


    @Override
    public CustomerProfileRes getCustomer(CustomerProfileReq customerProfileReq){
//        now select query to execute
        String selectSQL = "SELECT name, phone, email, address FROM customers WHERE email = ? or phone = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            preparedStatement.setString(1, customerProfileReq.getEmail());
            preparedStatement.setString(2, customerProfileReq.getPhone());

//            virtual table that stores the result
//            when you put contact info 1 unique record is expected
//            next - cursor first points to the first row, then to the second and so on but we dont know if there is a record or not
//            hence you check it in the while loop
            CustomerProfileRes response=new CustomerProfileRes();
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                response.setName(resultSet.getString("name"));
                response.setName(resultSet.getString("email"));
                response.setName(resultSet.getString("phone"));
                response.setName(resultSet.getString("address"));

                System.out.println("name: "+name);
                System.out.println("phone: "+phone);
                System.out.println("email: "+email);
                System.out.println("address: "+address);

                System.out.println(response);
                return response;

            }
        } catch (SQLException e){
            System.out.println(ERROR_MESSAGE);
        }
        return null;
    }


}
