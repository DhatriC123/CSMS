package com.cars24.validations;

import com.cars24.data.req.AddCustomerReq;

public class CustomerValidator {
    public static void validateAddCustomerRequest(AddCustomerReq addCustomerReq) {
//        database calling is expensive hence checking has to be done way before
//        dividing into smaller pieces
        validateCustomerName(addCustomerReq.getName());
        validateCustomerPhone(addCustomerReq.getPhone());
        validateCustomerEmail(addCustomerReq.getEmail());
        validateCustomerAddress(addCustomerReq.getAddress());
    }
        private static String validateCustomerName(String name){
            if (name == null){
                throw new IllegalArgumentException("Name cannot be EMPTY");
            }
            if (name.length() < 3 || name.length() >100){
                throw new IllegalArgumentException("Name should be min 3 chars or 100 chars max");
            }

            return "";
        }

        private static String validateCustomerPhone(String name){

            return "";
        }

        private static String validateCustomerEmail(String name){

            return "";
        }

        private static String validateCustomerAddress(String name){

            return "";
        }






}
