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
        List<Customer> customersList=new ArrayList<Customer>();
        Connection conn = null;

        try {
            String sql="SELECT * FROM customer";
            conn = DatabaseHelper.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                Customer customer=new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customersList.add(customer);
            }


        } catch (SQLException e) {
            LOGGER.error("execute sql failure", e);
        } finally {
            DatabaseHelper.closeConnection(conn);
        }

        return customersList;
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
        return  false;
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return  false;
    }

    public boolean deleteCustomer(long id) {
        return false;
    }
}
