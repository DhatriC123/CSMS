package com.cars24.dao;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;

public interface CustomersDao {
    String createCustomer(AddCustomerReq addCustomerReq);
    CustomerProfileRes getCustomer(CustomerProfileReq customerProfileReq);
//    void updateCustomer();
//    void deleteCustomer();
}
