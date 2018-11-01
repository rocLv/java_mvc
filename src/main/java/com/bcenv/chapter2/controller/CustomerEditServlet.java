package com.bcenv.chapter2.controller;

import com.bcenv.chapter2.model.Customer;
import com.bcenv.chapter2.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/customer_edit")
public class CustomerEditServlet extends HttpServlet {
    private  static final CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Customer customer = customerService.getCustomer(Long.parseLong(id));
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("/WEB-INF/view/customer_edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("name", req.getParameter("name"));
        boolean result = customerService.updateCustomer(Long.parseLong(id), fieldMap);

        req.getRequestDispatcher("customer_show?id=" + id).forward(req, resp);

    }

}
