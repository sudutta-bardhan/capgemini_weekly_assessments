package com.capgemini.jdbc_jpa_hibernate_assessment.controller;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.jdbc_jpa_hibernate_assessment.dao.*;
import com.capgemini.jdbc_jpa_hibernate_assessment.entity.*;

public class CustomerController
{
    public static void main(String[] args)
    {
        CustomerDao customerDao = new CustomerDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();

        Customer c1 = new Customer();
        c1.setCustomerName("Sudutta Bardhan");
        c1.setEmail("suduttabardhan07@gmail.com");
        c1.setGender("Female");
        c1.setPhone(9831101667L);
        c1.setRegistrationDate(LocalDate.now());

        Order o1 = new Order();
        o1.setOrderNumber("100");
        o1.setProductName("MacBook");
        o1.setQuantity(1);
        o1.setPrice(185000);
        o1.setOrderDate(LocalDate.now());

        c1.setOrder(o1);
        o1.setCustomer(c1);
        
        System.out.println(customerDao.saveCustomer(c1));


        Customer c2 = new Customer();
        c2.setCustomerName("Ipsita Lenka");
        c2.setEmail("ipsitalenka@gmail.com");
        c2.setGender("Female");
        c2.setPhone(9123456780L);
        c2.setRegistrationDate(LocalDate.now());

        Order o2 = new Order();
        o2.setOrderNumber("101");
        o2.setProductName("iPhone 15");
        o2.setQuantity(1);
        o2.setPrice(80000);
        o2.setOrderDate(LocalDate.now());

        c2.setOrder(o2);
        o2.setCustomer(c2);
        
        System.out.println(customerDao.saveCustomer(c2));


        Customer c3 = new Customer();
        c3.setCustomerName("Anoushka Deb");
        c3.setEmail("anoushkadeb@gmail.com");
        c3.setGender("Female");
        c3.setPhone(9234567810L);
        c3.setRegistrationDate(LocalDate.now());

        Order o3 = new Order();
        o3.setOrderNumber("102");
        o3.setProductName("Samsung Galaxy S24");
        o3.setQuantity(1);
        o3.setPrice(75000);
        o3.setOrderDate(LocalDate.now());

        c3.setOrder(o3);
        o3.setCustomer(c3);
        
        System.out.println(customerDao.saveCustomer(c3));


        Customer c4 = new Customer();
        c4.setCustomerName("Abhishek Mandal");
        c4.setEmail("abhishekmandal@gmail.com");
        c4.setGender("Male");
        c4.setPhone(9345678120L);
        c4.setRegistrationDate(LocalDate.now());

        Order o4 = new Order();
        o4.setOrderNumber("103");
        o4.setProductName("Dell XPS 13");
        o4.setQuantity(1);
        o4.setPrice(120000);
        o4.setOrderDate(LocalDate.now());

        c4.setOrder(o4);
        o4.setCustomer(c4);

        System.out.println(customerDao.saveCustomer(c4));

        Customer c5 = new Customer();
        c5.setCustomerName("Sulagna Ghosh");
        c5.setEmail("sulagnaghosh@gmail.com");
        c5.setGender("Female");
        c5.setPhone(9456781230L);
        c5.setRegistrationDate(LocalDate.now());

        Order o5 = new Order();
        o5.setOrderNumber("104");
        o5.setProductName("iPad Pro");
        o5.setQuantity(1);
        o5.setPrice(95000);
        o5.setOrderDate(LocalDate.now());

        c5.setOrder(o5);
        o5.setCustomer(c5);

        System.out.println(customerDao.saveCustomer(c5));

        Customer updateCustomer = customerDao.getCustomerById(3);

        if(updateCustomer != null)
        {
            updateCustomer.setCustomerName("Jake");
            System.out.println(customerDao.updateCustomer(updateCustomer));
        }


        Customer c = customerDao.getCustomerById(1);

        if(c != null)
        {
            System.out.println("Customer Name : " + c.getCustomerName());
            System.out.println("Email : " + c.getEmail());
            System.out.println("Order Product : " + c.getOrder().getProductName());
        }


        List<Customer> customers = customerDao.getAllCustomers();

        for(Customer cust : customers)
        {
            System.out.println("Customer ID : " + cust.getId());
            System.out.println("Name : " + cust.getCustomerName());
            System.out.println("Email : " + cust.getEmail());
        }

        Customer emailCustomer = customerDao.getCustomerByEmail("suduttabardhan07@gmail.com");

        if(emailCustomer != null)
        {
            System.out.println("Customer Found : " + emailCustomer.getCustomerName());
        }

        Order updateOrder = orderDao.getOrderById(1);

        if(updateOrder != null)
        {
            updateOrder.setPrice(80000);
            System.out.println(orderDao.updateOrder(updateOrder));
        }

        Order orderData = orderDao.getOrderById(1);

        if(orderData != null)
        {
            System.out.println("Order Number : " + orderData.getOrderNumber());
            System.out.println("Product : " + orderData.getProductName());
            System.out.println("Price : " + orderData.getPrice());
        }

        Customer deleteCustomer = customerDao.getCustomerById(2);

        if(deleteCustomer != null)
        {
            System.out.println(customerDao.deleteCustomerById(2));
        }
    }
}