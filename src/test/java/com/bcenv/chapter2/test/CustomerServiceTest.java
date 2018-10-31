package com.bcenv.chapter2.test;

import com.bcenv.chapter2.model.Customer;
import com.bcenv.chapter2.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService=new CustomerService();
    }

    @Before
    public void init() {
        //TODO initial database
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
