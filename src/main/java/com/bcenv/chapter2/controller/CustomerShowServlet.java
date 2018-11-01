package com.bcenv.chapter2.controller;

import com.bcenv.chapter2.model.Customer;
import com.bcenv.chapter2.service.CustomerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer_show")
public class CustomerShowServlet extends HttpServlet {
    private static final CustomerService custerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Customer customer = custerService.getCustomer(Long.parseLong(req.getParameter("id")));
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("/WEB-INF/view/customer_show.jsp");
    }
}
