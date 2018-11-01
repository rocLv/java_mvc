package com.bcenv.chapter2.test;

import com.bcenv.chapter2.helper.DatabaseHelper;
import com.bcenv.chapter2.model.Customer;
import com.bcenv.chapter2.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService=new CustomerService();
    }

    @Before
    public void init() throws IOException {
        //TODO initial database
        String file="sql/customer_init.sql";
        DatabaseHelper.executeSqlFile(file);
    }

    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customerList=customerService.getCustomerList();
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception {
        long id=1;
        Customer customer=customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }
}
