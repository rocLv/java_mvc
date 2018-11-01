package com.bcenv.chapter2.service;

import com.bcenv.chapter2.helper.DatabaseHelper;
import com.bcenv.chapter2.model.Customer;
import com.bcenv.chapter2.util.PropsUtil;

import java.sql.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerService {
    private static final Logger LOGGER= LoggerFactory.getLogger(DatabaseHelper.class);

    public List<Customer> getCustomerList() {


       String sql = "SELECT * FROM customer";
       return DatabaseHelper.queryEntityList(Customer.class, sql);

    }

    public Customer getCustomer(long id) {
        Iterator<Customer> iterator = getCustomerList().iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getId() == id) {
                return customer;
            }
        }

        return null;
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {
        return  DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return  DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
