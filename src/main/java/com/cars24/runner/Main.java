package com.cars24.runner;

import com.cars24.config.DbConfig;
import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.services.impl.CustomerServiceImpl;
import com.cars24.util.DbUtil;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application starts");

        try {
            DriverManager.getConnection(DbConfig.host, DbConfig.username, DbConfig.password);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            throw new RuntimeException(e);
        }
        //  DbUtil.getDbConnection(); //connected java to db

        //CustomerDaoImpl cust_dao = new CustomerDaoImpl();

//        cust_dao.createCustomer("John Doe", "9876543210", "john.doe@example.com", "Bangalore");
//        CustomerServiceImpl cust_service = new CustomerServiceImpl();

//        AddCustomerReq addCustomerReq = new AddCustomerReq();

//        addCustomerReq.setName("");
//        addCustomerReq.setPhone("");
//        addCustomerReq.setEmail("");
//        addCustomerReq.setAddress("");
//
//       String message = cust_dao.createCustomerV2("Kouu","8861773225","kousthubha.gk@cars24.com", "Bangalore");
//        String message = cust_service.registerCustomer(addCustomerReq);
//        System.out.println(message);
//        cannot do both at once - comment one out

//        CustomerDaoImpl cust_dao = new CustomerDaoImpl();
//        CustomerProfileReq customerProfileReq = new CustomerProfileReq();
//        customerProfileReq.setEmail("kousthubha.gk@cars24.com");
//        customerProfileReq.setPhone("8861773225");
//
//        cust_dao.getCustomer(customerProfileReq);
//
//        CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
//
//        CustomerProfileReq req=new CustomerProfileReq();
//        req.setEmail("hhyy@g");
//        req.setPhone("0997655555");
//
//        CustomerProfileRes response=customerDaoImpl.getCustomer(req);
//        System.out.println(response);

        //CustomerService.getCustomerProfile(req);


        CustomerDaoImpl customerDao = new CustomerDaoImpl();

        // Create and populate a CustomerProfileReq object
                      // Example phone to search for

        // Call the getCustomer method

        //CustomerProfileReq prof1=new CustomerProfileReq();
        //prof1.setEmail("rick@mail");
        //prof1.setPhone("1234567891");



        //Getting customer records
        CustomerProfileReq req = new CustomerProfileReq();
        req.setEmail("rita08@example.com"); // Example email to search for
        req.setPhone("0000543210");// Example phone to search for
        //CustomerDaoImpl cust=new CustomerDaoImpl();
        CustomerServiceImpl cust=new  CustomerServiceImpl();

        CustomerProfileRes response = cust.getCustomerProfile(req);


        //Creating customer records
        AddCustomerReq cust_req=new AddCustomerReq();
        cust_req.setName("rickvi");
        cust_req.setPhone("123432145");
        cust_req.setAddress("bng");
        cust_req.setEmail("r3@mail");
        cust.registerCustomer(cust_req);






    }


}