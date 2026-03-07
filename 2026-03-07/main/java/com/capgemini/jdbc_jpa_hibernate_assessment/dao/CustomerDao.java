package com.capgemini.jdbc_jpa_hibernate_assessment.dao;

import java.util.List;
import com.capgemini.jdbc_jpa_hibernate_assessment.entity.*;

public interface CustomerDao
{

    String saveCustomer(Customer customer);

    String updateCustomer(Customer customer);

    String deleteCustomerById(int id);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomers();

    Customer getCustomerByEmail(String email);

}